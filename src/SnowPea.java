import javax.swing.*;
import java.awt.*;

public class SnowPea extends Plants{
    public SnowPea(int row, int col){
        super(row,col,100,150,90);
        this.plantImage=new ImageIcon(getClass().getResource("/resources/snowpea1.png")).getImage();
        animation=new Image[8];
        animation[0]=new ImageIcon(getClass().getResource("/resources/snowpea3.png")).getImage();
        animation[1]=new ImageIcon(getClass().getResource("/resources/snowpea2.png")).getImage();
        animation[2]=new ImageIcon(getClass().getResource("/resources/snowpea1.png")).getImage();
        animation[3]=new ImageIcon(getClass().getResource("/resources/snowpea4.png")).getImage();
        animation[4]=new ImageIcon(getClass().getResource("/resources/snowpea5.png")).getImage();
        animation[7]=new ImageIcon(getClass().getResource("/resources/snowpea2.png")).getImage();
        animation[6]=new ImageIcon(getClass().getResource("/resources/snowpea1.png")).getImage();
        animation[5]=new ImageIcon(getClass().getResource("/resources/snowpea4.png")).getImage();
    }

    @Override
    public void performAction(GameEngine engine) {
        int startX=this.col*CELLSIZE;
        Pea newPea=new Pea(this.row,startX,20);
        newPea.makeSnow();
        engine.addProjectile(newPea);
    }
    public void performSpecial(GameEngine engine){
        int startX=this.col*CELLSIZE+32;
        int[] rows={0,1,2,3,4};
        for(int i: rows){
            Pea newPea=new Pea(i,startX,20);
            newPea.makeSnow();
            engine.addProjectile(newPea);
        }
        performedSpecial=true;
        this.plantImage=new ImageIcon(getClass().getResource("/resources/snowpeaS.png")).getImage();
    }
    void draw(Graphics g){
        g.drawImage(this.plantImage,row*CELLSIZE,col*CELLSIZE,null);
    }
    @Override
    public void reloadImage() {
        this.plantImage = new ImageIcon(getClass().getResource("/resources/snowpea1.png")).getImage();
        animation=new Image[8];
        animation[0]=new ImageIcon(getClass().getResource("/resources/snowpea3.png")).getImage();
        animation[1]=new ImageIcon(getClass().getResource("/resources/snowpea2.png")).getImage();
        animation[2]=new ImageIcon(getClass().getResource("/resources/snowpea1.png")).getImage();
        animation[3]=new ImageIcon(getClass().getResource("/resources/snowpea4.png")).getImage();
        animation[4]=new ImageIcon(getClass().getResource("/resources/snowpea5.png")).getImage();
        animation[7]=new ImageIcon(getClass().getResource("/resources/snowpea2.png")).getImage();
        animation[6]=new ImageIcon(getClass().getResource("/resources/snowpea1.png")).getImage();
        animation[5]=new ImageIcon(getClass().getResource("/resources/snowpea4.png")).getImage();
    }
}
