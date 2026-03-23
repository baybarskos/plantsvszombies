import javax.swing.*;
import java.awt.*;

public class PeaShooter extends Plants{
    private static final Image MAIN_IMG = new ImageIcon(PeaShooter.class.getResource("/resources/peashooter1.png")).getImage();
    private static final Image[] ANIM_FRAMES = new Image[8];
    static {
        ANIM_FRAMES[0] = new ImageIcon(PeaShooter.class.getResource("/resources/peashooter3.png")).getImage();
        ANIM_FRAMES[1] = new ImageIcon(PeaShooter.class.getResource("/resources/peashooter2.png")).getImage();
        ANIM_FRAMES[2] = new ImageIcon(PeaShooter.class.getResource("/resources/peashooter1.png")).getImage();
        ANIM_FRAMES[3] = new ImageIcon(PeaShooter.class.getResource("/resources/peashooter4.png")).getImage();
        ANIM_FRAMES[4] = new ImageIcon(PeaShooter.class.getResource("/resources/peashooter5.png")).getImage();
        ANIM_FRAMES[7] = new ImageIcon(PeaShooter.class.getResource("/resources/peashooter2.png")).getImage();
        ANIM_FRAMES[6] = new ImageIcon(PeaShooter.class.getResource("/resources/peashooter1.png")).getImage();
        ANIM_FRAMES[5] = new ImageIcon(PeaShooter.class.getResource("/resources/peashooter4.png")).getImage();
    }
    private static final Image SPECIAL_IMG=new ImageIcon(PeaShooter.class.getResource("/resources/peashooterS.png")).getImage();
    public PeaShooter(int row,int col){
        super(row,col,100,100,90);
        this.plantImage=MAIN_IMG;
        this.animation=ANIM_FRAMES;
    }
    public void performAction(GameEngine engine) {
        int startX=this.col*CELLSIZE+32;
        Pea newPea=new Pea(this.row,startX,20);
        engine.addProjectile(newPea);
    }
    public void performSpecial(GameEngine engine){
        int startX=this.col*CELLSIZE;
        for(int i=0;i<7;i++){
            Pea newPea=new Pea(this.row,startX+i*30,20);
            engine.addProjectile(newPea);
        }
        this.plantImage=SPECIAL_IMG;
        performedSpecial=true;
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
