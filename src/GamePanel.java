import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements CellSize {
    private GameEngine engine;

    public GamePanel(GameEngine engine) {
        this.engine = engine;
        setLayout(new GridLayout(5, 9));
    }

    
    @Override
    public void paint(Graphics g) {
        
        super.paint(g);

        if (engine != null) {
            for(Plants plant: engine.getActivePlants()){
                if(plant!=null&&!plant.performedSpecial){
                    Image[] img=plant.animation;
                    if(img!=null){
                        g.drawImage(img[plant.currentFrame],plant.col*CELLSIZE,plant.row*CELLSIZE,CELLSIZE,CELLSIZE,this);}
                }
                if(plant!=null&&plant.performedSpecial){
                    Image img=plant.getImage();
                    if(img!=null){
                        g.drawImage(img,plant.col*CELLSIZE,plant.row*CELLSIZE,CELLSIZE,CELLSIZE,this);
                    }
                }
        }
            for (Projectiles proj : engine.getActiveProjectiles()) {
                
                Image img = proj.getImage();
                if (img != null) {
                    
                    int yPixel = proj.getRow() * CELLSIZE; 
                    g.drawImage(img, proj.getXPosition(), yPixel, CELLSIZE, CELLSIZE, this);
                }
            }

            
            for (Zombies zombie : engine.getActiveZombies()) {
                Image[] img = zombie.animation;
                if (img != null) {
                    int yPixel = zombie.getRow() * CELLSIZE;
                    
                    g.drawImage(img[zombie.currentFrame], (int)zombie.getXPosition(), yPixel, CELLSIZE, CELLSIZE, this);
                }
            }
        }
    }
}
