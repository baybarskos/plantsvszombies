import javax.swing.*;
import java.awt.*;

public class SunFlower extends Plants{

    SunFlower(int row,int col){
        super(row,col,100,50,300);
        this.plantImage=new ImageIcon(getClass().getResource("/resources/sunflower1.png")).getImage();
        animation=new Image[8];
        animation[0]=new ImageIcon(getClass().getResource("/resources/sunflower3.png")).getImage();
        animation[1]=new ImageIcon(getClass().getResource("/resources/sunflower2.png")).getImage();
        animation[2]=new ImageIcon(getClass().getResource("/resources/sunflower1.png")).getImage();
        animation[3]=new ImageIcon(getClass().getResource("/resources/sunflower4.png")).getImage();
        animation[4]=new ImageIcon(getClass().getResource("/resources/sunflower5.png")).getImage();
        animation[7]=new ImageIcon(getClass().getResource("/resources/sunflower2.png")).getImage();
        animation[6]=new ImageIcon(getClass().getResource("/resources/sunflower1.png")).getImage();
        animation[5]=new ImageIcon(getClass().getResource("/resources/sunflower4.png")).getImage();
    }

    @Override
    public void performAction(GameEngine engine) {
        Sun newSun=new Sun(row,col*CELLSIZE);
        engine.addProjectile(newSun);
    }
    public void performSpecial(GameEngine engine) {
        for(int i=0;i<5;i++) {
            Sun newSun=new Sun(row,col*CELLSIZE);
            engine.addProjectile(newSun);
            plantImage=new ImageIcon(getClass().getResource("/resources/sunflowerS.png")).getImage();
            performedSpecial=true;
        }
    }
    @Override
    public void reloadImage() {
        this.plantImage = new ImageIcon(getClass().getResource("/resources/sunflower1.png")).getImage();
        performedSpecial=false;
        animation=new Image[8];
        animation[0]=new ImageIcon(getClass().getResource("/resources/sunflower3.png")).getImage();
        animation[1]=new ImageIcon(getClass().getResource("/resources/sunflower2.png")).getImage();
        animation[2]=new ImageIcon(getClass().getResource("/resources/sunflower1.png")).getImage();
        animation[3]=new ImageIcon(getClass().getResource("/resources/sunflower4.png")).getImage();
        animation[4]=new ImageIcon(getClass().getResource("/resources/sunflower5.png")).getImage();
        animation[7]=new ImageIcon(getClass().getResource("/resources/sunflower2.png")).getImage();
        animation[6]=new ImageIcon(getClass().getResource("/resources/sunflower1.png")).getImage();
        animation[5]=new ImageIcon(getClass().getResource("/resources/sunflower4.png")).getImage();
    }
}
