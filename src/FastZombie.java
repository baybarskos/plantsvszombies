import javax.swing.*;
import java.awt.*;
public class FastZombie extends Zombies{
    private static final Image MAIN_IMG = new ImageIcon(FastZombie.class.getResource("/resources/fastzombie1.png")).getImage();
    private static final Image[] ANIM_FRAMES = new Image[8];
    static {
        ANIM_FRAMES[0] = new ImageIcon(FastZombie.class.getResource("/resources/fastzombie3.png")).getImage();
        ANIM_FRAMES[1] = new ImageIcon(FastZombie.class.getResource("/resources/fastzombie2.png")).getImage();
        ANIM_FRAMES[2] = new ImageIcon(FastZombie.class.getResource("/resources/fastzombie1.png")).getImage();
        ANIM_FRAMES[3] = new ImageIcon(FastZombie.class.getResource("/resources/fastzombie4.png")).getImage();
        ANIM_FRAMES[4] = new ImageIcon(FastZombie.class.getResource("/resources/fastzombie5.png")).getImage();
        ANIM_FRAMES[7] = new ImageIcon(FastZombie.class.getResource("/resources/fastzombie2.png")).getImage();
        ANIM_FRAMES[6] = new ImageIcon(FastZombie.class.getResource("/resources/fastzombie1.png")).getImage();
        ANIM_FRAMES[5] = new ImageIcon(FastZombie.class.getResource("/resources/fastzombie4.png")).getImage();
    }

    FastZombie(int row, int col) {
        super(row, col, 100, 2.5, 20);
        this.zombieImage = MAIN_IMG;
        this.animation = ANIM_FRAMES;
    }

    @Override
    public void reloadImage() {
        this.zombieImage = MAIN_IMG;
        this.animation = ANIM_FRAMES;
    }
}
