import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.*;

public class GameEngine implements ActionListener,CellSize {
    private Timer gameLoop;

    private List<Zombies> activeZombies = new CopyOnWriteArrayList<>();
    private List<Projectiles> activeProjectiles = new CopyOnWriteArrayList<>();
    private List<Plants> activePlants = new CopyOnWriteArrayList<>();

    private TopPanel topPanel;
    private JPanel gameBoard;

    private ZombieSpawner spawner;
    public boolean isPaused=false;
    private Thread spawnerThread;

    private Main main;
    private boolean allWavesSpawned=false;
    public List<GameArea> allGridSquares = new ArrayList<>();
    
    public GameEngine(TopPanel topPanel, JPanel gameBoard) {
        this.topPanel = topPanel;
        this.gameBoard = gameBoard;

        
        gameLoop = new Timer(16, this);//60 FPS
    }

    public void start() {
        if(gameLoop!=null &&!gameLoop.isRunning()) gameLoop.start();

        if(spawnerThread==null||!spawnerThread.isAlive()) {
            this.spawner = new ZombieSpawner(this);
            this.spawnerThread = new Thread(spawner);
            this.spawnerThread.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updatePlants();
        updateProjectiles();
        updateZombies();
        checkCollisions();

        gameBoard.repaint();
    }

    private void updatePlants() {
        for(Plants plant: activePlants){
            plant.update(this);
        }
    }
    public boolean collectSunAt(int r, int c) {
        int clickX = c * CELLSIZE;
        for (Projectiles proj : activeProjectiles) {
            if (proj instanceof Sun) {
                
                boolean rowIsClose = Math.abs(proj.getRow() - r) <= 0.5;

                
                boolean colIsClose = Math.abs(proj.getXPosition() - clickX) <= CELLSIZE/2;
                if (rowIsClose&&colIsClose) {
                    activeProjectiles.remove(proj);
                    return true;
                }
            }
        }
        return false;
    }

    private void updateProjectiles() {
        for (Projectiles proj : activeProjectiles) {
            proj.move();

            
            if (proj.xPosition > CELLSIZE*10) {
                activeProjectiles.remove(proj);
            }
        }
    }

    private void updateZombies() {
        for (Zombies zombie : activeZombies) {
            if (zombie != null) {
                zombie.move();

                if (zombie.getXPosition() < 0) {
                    resetBoard();
                    gameLoop.stop();
                    if (spawner != null) spawner.stop();
                    if (main != null) main.loseGame();
                    break;
                }
            }
        }
        if(allWavesSpawned&&activeZombies.isEmpty()){
            gameLoop.stop();
            if(main!=null) main.winGame();
        }
    }

    private void checkCollisions() {
        
        for (Projectiles proj : activeProjectiles) {
            
            if (proj instanceof Sun) continue;

            for (Zombies zombie : activeZombies) {
                
                if (proj.row == zombie.row && proj.getXPosition()>=zombie.getXPosition()) {
                    proj.hitZombie(zombie);
                    activeProjectiles.remove(proj);
                    break;
                }
            }
        }
        for(Zombies zombie: activeZombies){
            boolean isFacingPlant=false;
            for(Plants plant: activePlants){
                int PlantPixelX=plant.col*CELLSIZE;
                if(zombie.getRow()==plant.row&&zombie.getXPosition()<=PlantPixelX+CELLSIZE&&zombie.getXPosition()>=PlantPixelX){
                    zombie.attack(plant);
                    isFacingPlant=true;
                    break;
                }
            }
            if(!isFacingPlant){
                zombie.isAttacking=false;
            }
        }

        
        activeZombies.removeIf(GameObject::isDead);
        activePlants.removeIf(GameObject::isDead);
        activeProjectiles.removeIf(GameObject::isDead);
    }

    
    public void addProjectile(Projectiles p) { activeProjectiles.add(p); }
    public void addZombie(Zombies z) { activeZombies.add(z); }
    public void addPlant(Plants p) { activePlants.add(p); }
    public void removePlant(Plants p){ activePlants.remove(p);}
    public TopPanel getTopPanel() { return topPanel; }
    public List<Projectiles> getActiveProjectiles() {
        return activeProjectiles;
    }
    public List<Plants> getActivePlants(){
        return activePlants;
    }
    public List<Zombies> getActiveZombies() {
        return activeZombies;
    }
    public JPanel getGameBoard(){
        return gameBoard;
    }
    public void setGameBoard(JPanel board) {
        this.gameBoard = board;
    }
    public void setAllWavesSpawned(boolean waves){
        this.allWavesSpawned=waves;
    }
    public void setMain(Main main){
        this.main=main;
    }
    public void pauseAndSave(){
        if(isPaused) return;
        isPaused=true;
        gameLoop.stop();
        int WaveCount=1;
        if(spawner!=null) WaveCount=spawner.getWaveCount();
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("pvzsave.dat"))){
            GameState state=new GameState(activeZombies,activePlants,activeProjectiles, topPanel.currentSun,WaveCount);
            out.writeObject(state);
        } catch (IOException e){
            System.err.println("Error saving the game"+e.getMessage());
        }
    }
    public void resumeAndLoad(){
        GameState state;
        state=null;
        if(!isPaused) return;
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream("pvzsave.dat"))){
            state=(GameState) in.readObject();

            this.activeZombies=new CopyOnWriteArrayList<>(state.zombies);
            this.activePlants=new CopyOnWriteArrayList<>(state.plants);
            this.activeProjectiles=new CopyOnWriteArrayList<>(state.projectiles);

            for (Plants p : activePlants) p.reloadImage();
            for (Zombies z : activeZombies) z.reloadImage();
            for (Projectiles proj : activeProjectiles) proj.reloadImage();

            this.topPanel.currentSun= state.currentSun;
            this.topPanel.updateSunDisplay();

            for (int i = 0; i < 45; i++) {
                GameArea area = (GameArea) gameBoard.getComponent(i);
                area.setCurrentPlant(null);
            }
            for (Plants p : activePlants) {
                int index = (p.row * 9) + p.col;
                GameArea area = (GameArea) gameBoard.getComponent(index);
                area.setCurrentPlant(p);
            }
        } catch (IOException e){
            System.err.println("Error loading the game"+e.getMessage());
        } catch(ClassNotFoundException e){
            System.err.println("Class do not found."+e.getMessage());
        }
        isPaused=false;
        gameLoop.start();
        if(spawnerThread==null||!spawnerThread.isAlive()){
            this.spawner=new ZombieSpawner(this);
            spawner.setWaveCount(state.WaveCount);
            this.spawnerThread=new Thread(this.spawner);
            this.spawnerThread.start();
        }
    }

    public void resetBoard(){
        activeZombies.clear();
        activeProjectiles.clear();
        activePlants.clear();
        topPanel.currentSun=150;
        topPanel.resetButtons();

        isPaused=false;
        allWavesSpawned=false;
        for(GameArea area: allGridSquares){
            area.setCurrentPlant(null);
        }
        gameBoard.repaint();
        topPanel.updateSunDisplay();
        if(spawner!=null){
            spawner.stop();
            spawner=null;
        }
    }
}
