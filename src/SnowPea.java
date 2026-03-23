import javax.swing.*;
import java.awt.*;

public class SnowPea extends Plants{
    private static final Image MAIN_IMG = new ImageIcon(SnowPea.class.getResource("/resources/snowpea1.png")).getImage();
    private static final Image[] ANIM_FRAMES = new Image[8];
    static {
        ANIM_FRAMES[0] = new ImageIcon(SnowPea.class.getResource("/resources/snowpea3.png")).getImage();
        ANIM_FRAMES[1] = new ImageIcon(SnowPea.class.getResource("/resources/snowpea2.png")).getImage();
        ANIM_FRAMES[2] = new ImageIcon(SnowPea.class.getResource("/resources/snowpea1.png")).getImage();
        ANIM_FRAMES[3] = new ImageIcon(SnowPea.class.getResource("/resources/snowpea4.png")).getImage();
        ANIM_FRAMES[4] = new ImageIcon(SnowPea.class.getResource("/resources/snowpea5.png")).getImage();
        ANIM_FRAMES[7] = new ImageIcon(SnowPea.class.getResource("/resources/snowpea2.png")).getImage();
        ANIM_FRAMES[6] = new ImageIcon(SnowPea.class.getResource("/resources/snowpea1.png")).getImage();
        ANIM_FRAMES[5] = new ImageIcon(SnowPea.class.getResource("/resources/snowpea4.png")).getImage();
    }
    private static final Image SPECIAL_IMG=new ImageIcon(SnowPea.class.getResource("/resources/snowpeaS.png")).getImage();
    public SnowPea(int row,int col){
        super(row,col,100,150,90);
        this.plantImage=MAIN_IMG;
        this.animation=ANIM_FRAMES;
    }

    @Override
    public void performAction(GameEngine engine) {
        int startX=this.col*CELLSIZE;
        Pea newPea=new Pea(this.row,startX,20);
        newPea.makeSnow();
        engine.addProjectile(newPea);
    }
    public void performSpecial(GameEngine engine){
        int startX=this.col*CELLSIZE;
        int[] rows={0,1,2,3,4};
        for(int i: rows){
            Pea newPea=new Pea(i,startX,20);
            Pea newPea1=new Pea(i,startX+40,20);
            newPea.makeSnow();
            newPea1.makeSnow();
            engine.addProjectile(newPea);
            engine.addProjectile(newPea1);
        }
        performedSpecial=true;
        this.plantImage=SPECIAL_IMG;
    }
    void draw(Graphics g){
        g.drawImage(this.plantImage,row*CELLSIZE,col*CELLSIZE,null);
    }
    @Override
    public void reloadImage() {
        this.plantImage = MAIN_IMG;
        this.animation=ANIM_FRAMES;
    }
}
