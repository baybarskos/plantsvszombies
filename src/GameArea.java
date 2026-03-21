import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameArea extends JPanel implements CellSize {
    private int row;
    private int col;
    private Plants currentPlant=null;
    private TopPanel topPanel;

    private GameEngine engine;

    public GameArea(int row,int col, TopPanel topPanel,GameEngine engine){
        this.row=row;this.col=col;this.topPanel=topPanel;
        setPreferredSize(new Dimension(CELLSIZE,CELLSIZE));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        if((row+col)%2==0)
        setBackground(new Color(30, 141, 30));
        else setBackground(new Color(19, 92, 26));
        this.engine=engine;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleCellClick();
            }
        });
    }
    private void handleCellClick(){
        if(engine.collectSunAt(row,col)){
            topPanel.addSun(25);
            repaint();
            return;
        }
        String selectedPlant= topPanel.getSelectedPlantName();
        if(selectedPlant==null){
            return;
        }
        if(currentPlant!=null&&currentPlant.isDead()){
            currentPlant=null;
        }
        if(currentPlant!=null){
            if(selectedPlant.equals("Shovel")){
                engine.getActivePlants().remove(this.currentPlant);
                currentPlant=null;
                topPanel.clearSelection();
                repaint();
            }
            if(selectedPlant.equals("PlantFood")){
                currentPlant.performSpecial(engine);
                topPanel.performedTotalTime++;
                topPanel.plantFood.setText(3-topPanel.performedTotalTime+" PlantFood");
                if(topPanel.performedTotalTime>=3) {
                    topPanel.plantFood.setEnabled(false);
                }
                topPanel.clearSelection();
                repaint();
            }
            return;
        }
        int cost=0;
        Plants newPlant=null;
        switch(selectedPlant){
            case "PeaShooter":
                cost=100;
                newPlant=new PeaShooter(row,col);
                break;
            case "SunFlower":
                cost=50;
                newPlant=new SunFlower(row,col);
                break;
            case "SnowPea":
                cost=150;
                newPlant=new SnowPea(row,col);
                break;
            case "WallNut":
                cost=50;
                newPlant=new WallNut(row,col);
                break;
            case "CherryBomb":
                cost=125;
                newPlant=new CherryBomb(row,col);
                break;
        }
        if(newPlant!=null&&topPanel.spendSun(cost)){
            currentPlant=newPlant;
            engine.addPlant(newPlant);
            topPanel.clearSelection();
            repaint();
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(currentPlant!=null&&currentPlant.health<=0) currentPlant=null;
        if(currentPlant!=null&&!currentPlant.performedSpecial){
            Image[] img=currentPlant.animation;
            if(img!=null){
                g.drawImage(img[currentPlant.currentFrame],0,0,CELLSIZE,CELLSIZE,this);}
        }
        if(currentPlant!=null&&currentPlant.performedSpecial){
            Image img=currentPlant.getImage();
            if(img!=null){
                g.drawImage(img,0,0,CELLSIZE,CELLSIZE,this);
            }
        }
    }
    public Plants getCurrentPlant(){return currentPlant;}
    public void setCurrentPlant(Plants plant){this.currentPlant=plant;}
}
