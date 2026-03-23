import javax.swing.*;
import java.awt.*;
public class TankZombie extends Zombies{
    private static final Image MAIN_IMG = new ImageIcon(TankZombie.class.getResource("/resources/tankzombie1.png")).getImage();
    private static final Image[] ANIM_FRAMES = new Image[8];
    static {
        ANIM_FRAMES[0] = new ImageIcon(TankZombie.class.getResource("/resources/tankzombie3.png")).getImage();
        ANIM_FRAMES[1] = new ImageIcon(TankZombie.class.getResource("/resources/tankzombie2.png")).getImage();
        ANIM_FRAMES[2] = new ImageIcon(TankZombie.class.getResource("/resources/tankzombie1.png")).getImage();
        ANIM_FRAMES[3] = new ImageIcon(TankZombie.class.getResource("/resources/tankzombie4.png")).getImage();
        ANIM_FRAMES[4] = new ImageIcon(TankZombie.class.getResource("/resources/tankzombie5.png")).getImage();
        ANIM_FRAMES[7] = new ImageIcon(TankZombie.class.getResource("/resources/tankzombie2.png")).getImage();
        ANIM_FRAMES[6] = new ImageIcon(TankZombie.class.getResource("/resources/tankzombie1.png")).getImage();
        ANIM_FRAMES[5] = new ImageIcon(TankZombie.class.getResource("/resources/tankzombie4.png")).getImage();
    }

    TankZombie(int row, int col) {
        super(row, col, 240, 6, 20);
        this.zombieImage = MAIN_IMG;
        this.animation = ANIM_FRAMES;
    }

    @Override
    public void reloadImage() {
        this.zombieImage = MAIN_IMG;
        this.animation = ANIM_FRAMES;
    }
}