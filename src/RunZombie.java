import javax.swing.*;
import java.awt.*;
public class RunZombie extends Zombies{
    private static final Image MAIN_IMG = new ImageIcon(RunZombie.class.getResource("/resources/runzombie1.png")).getImage();
    private static final Image[] ANIM_FRAMES = new Image[8];
    static {
        ANIM_FRAMES[0] = new ImageIcon(RunZombie.class.getResource("/resources/runzombie3.png")).getImage();
        ANIM_FRAMES[1] = new ImageIcon(RunZombie.class.getResource("/resources/runzombie2.png")).getImage();
        ANIM_FRAMES[2] = new ImageIcon(RunZombie.class.getResource("/resources/runzombie1.png")).getImage();
        ANIM_FRAMES[3] = new ImageIcon(RunZombie.class.getResource("/resources/runzombie4.png")).getImage();
        ANIM_FRAMES[4] = new ImageIcon(RunZombie.class.getResource("/resources/runzombie5.png")).getImage();
        ANIM_FRAMES[7] = new ImageIcon(RunZombie.class.getResource("/resources/runzombie2.png")).getImage();
        ANIM_FRAMES[6] = new ImageIcon(RunZombie.class.getResource("/resources/runzombie1.png")).getImage();
        ANIM_FRAMES[5] = new ImageIcon(RunZombie.class.getResource("/resources/runzombie4.png")).getImage();
    }

    RunZombie(int row, int col) {
        super(row, col, 100, 6, 20);
        this.zombieImage = MAIN_IMG;
        this.animation = ANIM_FRAMES;
    }

    @Override
    public void reloadImage() {
        this.zombieImage = MAIN_IMG;
        this.animation = ANIM_FRAMES;
    }
}