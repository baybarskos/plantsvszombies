import javax.swing.*;
import java.awt.*;

public class WallNut extends Plants{
    public WallNut(int row, int col){
        super(row,col,500,50,0,999999);
        this.plantImage=new ImageIcon(getClass().getResource("/resources/wallnut.png")).getImage();
        animation=new Image[8];
        animation[0]=new ImageIcon(getClass().getResource("/resources/wallnut3.png")).getImage();
        animation[1]=new ImageIcon(getClass().getResource("/resources/wallnut2.png")).getImage();
        animation[2]=new ImageIcon(getClass().getResource("/resources/wallnut1.png")).getImage();
        animation[3]=new ImageIcon(getClass().getResource("/resources/wallnut4.png")).getImage();
        animation[4]=new ImageIcon(getClass().getResource("/resources/wallnut5.png")).getImage();
        animation[7]=new ImageIcon(getClass().getResource("/resources/wallnut2.png")).getImage();
        animation[6]=new ImageIcon(getClass().getResource("/resources/wallnut1.png")).getImage();
        animation[5]=new ImageIcon(getClass().getResource("/resources/wallnut4.png")).getImage();
    }

    @Override
    public void performAction(GameEngine engine) {}
    public void performSpecial(GameEngine engine){
        this.health*=2;
        performedSpecial=true;
        this.plantImage=new ImageIcon(getClass().getResource("/resources/wallnutS.png")).getImage();
        specialAnimationTick=10000000;

    }
    @Override
    public void reloadImage() {
        this.plantImage = new ImageIcon(getClass().getResource("/resources/wallnutS.png")).getImage();
        animation=new Image[8];
        animation[0]=new ImageIcon(getClass().getResource("/resources/wallnut3.png")).getImage();
        animation[1]=new ImageIcon(getClass().getResource("/resources/wallnut2.png")).getImage();
        animation[2]=new ImageIcon(getClass().getResource("/resources/wallnut1.png")).getImage();
        animation[3]=new ImageIcon(getClass().getResource("/resources/wallnut4.png")).getImage();
        animation[4]=new ImageIcon(getClass().getResource("/resources/wallnut5.png")).getImage();
        animation[7]=new ImageIcon(getClass().getResource("/resources/wallnut2.png")).getImage();
        animation[6]=new ImageIcon(getClass().getResource("/resources/wallnut1.png")).getImage();
        animation[5]=new ImageIcon(getClass().getResource("/resources/wallnut4.png")).getImage();
        
    }
}
