import javax.swing.*;
import java.awt.*;

public class CherryBomb extends Plants{
    public CherryBomb(int row,int col){
        super(row,col,1,125,20);
        animationSpeed=7;
        this.plantImage=new ImageIcon(getClass().getResource("/resources/cherrybomb1.png")).getImage();
        animation=new Image[3];
        animation[0]=new ImageIcon(getClass().getResource("/resources/cherrybomb1.png")).getImage();
        animation[1]=new ImageIcon(getClass().getResource("/resources/cherrybomb2.png")).getImage();
        animation[2]=new ImageIcon(getClass().getResource("/resources/cherrybomb3.png")).getImage();
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
        this.plantImage = new ImageIcon(getClass().getResource("/resources/cherrybomb1.png")).getImage();

    }
    @Override
    public void reloadImage() {
        this.plantImage = new ImageIcon(getClass().getResource("/resources/cherrybomb1.png")).getImage();
        animation=new Image[3];
        animation[0]=new ImageIcon(getClass().getResource("/resources/cherrybomb1.png")).getImage();
        animation[1]=new ImageIcon(getClass().getResource("/resources/cherrybomb2.png")).getImage();
        animation[2]=new ImageIcon(getClass().getResource("/resources/cherrybomb3.png")).getImage();
    }
}
