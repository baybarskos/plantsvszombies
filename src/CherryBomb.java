import javax.swing.*;
import java.awt.*;

public class CherryBomb extends Plants{
    private static final Image MAIN_IMG = new ImageIcon(CherryBomb.class.getResource("/resources/cherrybomb1.png")).getImage();
    private static final Image[] ANIM_FRAMES = new Image[3];
    static {
        ANIM_FRAMES[0] = new ImageIcon(CherryBomb.class.getResource("/resources/cherrybomb3.png")).getImage();
        ANIM_FRAMES[1] = new ImageIcon(CherryBomb.class.getResource("/resources/cherrybomb2.png")).getImage();
        ANIM_FRAMES[2] = new ImageIcon(CherryBomb.class.getResource("/resources/cherrybomb1.png")).getImage();
    }
    public CherryBomb(int row,int col){
        super(row,col,1000,125,20);
        animationSpeed=7;
        this.plantImage=MAIN_IMG;
        this.animation=ANIM_FRAMES;
    }

    @Override
    public void performAction(GameEngine engine) {
        int cellLeft=(this.col)*CELLSIZE;
        for(Zombies zombie: engine.getActiveZombies()){
            if(zombie.getRow()==this.row){
                if(zombie.getXPosition()>=cellLeft-CELLSIZE&&zombie.getXPosition()<=cellLeft+CELLSIZE+CELLSIZE/8){
                    zombie.health=0;
                }
            }
        }
        this.health=0;
    }
    public void performSpecial(GameEngine engine){
        int cellLeft=this.col*CELLSIZE;
        for(Zombies zombie: engine.getActiveZombies()){
                zombie.health=0;
        }
        this.health=0;
        performedSpecial=true;
        this.plantImage = MAIN_IMG;

    }
    @Override
    public void reloadImage() {
        this.plantImage = MAIN_IMG;
        this.animation=ANIM_FRAMES;
    }
}
