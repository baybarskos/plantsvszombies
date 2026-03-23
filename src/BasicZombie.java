import javax.swing.*;
import java.awt.*;

public class BasicZombie extends Zombies{
    private static final Image MAIN_IMG = new ImageIcon(BasicZombie.class.getResource("/resources/basiczombie1.png")).getImage();
    private static final Image[] ANIM_FRAMES = new Image[8];
    static {
        ANIM_FRAMES[0] = new ImageIcon(BasicZombie.class.getResource("/resources/basiczombie3.png")).getImage();
        ANIM_FRAMES[1] = new ImageIcon(BasicZombie.class.getResource("/resources/basiczombie2.png")).getImage();
        ANIM_FRAMES[2] = new ImageIcon(BasicZombie.class.getResource("/resources/basiczombie1.png")).getImage();
        ANIM_FRAMES[3] = new ImageIcon(BasicZombie.class.getResource("/resources/basiczombie4.png")).getImage();
        ANIM_FRAMES[4] = new ImageIcon(BasicZombie.class.getResource("/resources/basiczombie5.png")).getImage();
        ANIM_FRAMES[7] = new ImageIcon(BasicZombie.class.getResource("/resources/basiczombie2.png")).getImage();
        ANIM_FRAMES[6] = new ImageIcon(BasicZombie.class.getResource("/resources/basiczombie1.png")).getImage();
        ANIM_FRAMES[5] = new ImageIcon(BasicZombie.class.getResource("/resources/basiczombie4.png")).getImage();
    }

    BasicZombie(int row, int col) {
        super(row, col, 100, 1.5, 20);
        this.zombieImage = MAIN_IMG;
        this.animation = ANIM_FRAMES;
    }

    @Override
    public void reloadImage() {
        this.zombieImage = MAIN_IMG;
        this.animation = ANIM_FRAMES;
    }
}
