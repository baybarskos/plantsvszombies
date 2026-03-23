import javax.swing.*;
import java.awt.*;

public class WallNut extends Plants {
    private static final Image MAIN_IMG = new ImageIcon(WallNut.class.getResource("/resources/wallnut1.png")).getImage();
    private static final Image[] ANIM_FRAMES = new Image[8];

    static {
        ANIM_FRAMES[0] = new ImageIcon(WallNut.class.getResource("/resources/wallnut3.png")).getImage();
        ANIM_FRAMES[1] = new ImageIcon(WallNut.class.getResource("/resources/wallnut2.png")).getImage();
        ANIM_FRAMES[2] = new ImageIcon(WallNut.class.getResource("/resources/wallnut1.png")).getImage();
        ANIM_FRAMES[3] = new ImageIcon(WallNut.class.getResource("/resources/wallnut4.png")).getImage();
        ANIM_FRAMES[4] = new ImageIcon(WallNut.class.getResource("/resources/wallnut5.png")).getImage();
        ANIM_FRAMES[7] = new ImageIcon(WallNut.class.getResource("/resources/wallnut2.png")).getImage();
        ANIM_FRAMES[6] = new ImageIcon(WallNut.class.getResource("/resources/wallnut1.png")).getImage();
        ANIM_FRAMES[5] = new ImageIcon(WallNut.class.getResource("/resources/wallnut4.png")).getImage();
    }

    private static final Image SPECIAL_IMG = new ImageIcon(WallNut.class.getResource("/resources/wallnutS.png")).getImage();

    public WallNut(int row, int col) {
        super(row, col, 500, 50, 0, 999999);
        this.plantImage = MAIN_IMG;
        this.animation = ANIM_FRAMES;
    }

    @Override
    public void performAction(GameEngine engine) {
    }

    public void performSpecial(GameEngine engine) {
        this.health = 1200;
        performedSpecial = true;
        this.plantImage = SPECIAL_IMG;
    }

    @Override
    public void reloadImage() {
        this.plantImage = new ImageIcon(getClass().getResource("/resources/wallnutS.png")).getImage();
        this.animation = ANIM_FRAMES;
    }
}
