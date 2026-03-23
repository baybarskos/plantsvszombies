import javax.swing.*;
import java.awt.*;

public class SunFlower extends Plants {
    private static final Image MAIN_IMG = new ImageIcon(SunFlower.class.getResource("/resources/sunflower1.png")).getImage();
    private static final Image[] ANIM_FRAMES = new Image[8];

    static {
        ANIM_FRAMES[0] = new ImageIcon(SunFlower.class.getResource("/resources/sunflower3.png")).getImage();
        ANIM_FRAMES[1] = new ImageIcon(SunFlower.class.getResource("/resources/sunflower2.png")).getImage();
        ANIM_FRAMES[2] = new ImageIcon(SunFlower.class.getResource("/resources/sunflower1.png")).getImage();
        ANIM_FRAMES[3] = new ImageIcon(SunFlower.class.getResource("/resources/sunflower4.png")).getImage();
        ANIM_FRAMES[4] = new ImageIcon(SunFlower.class.getResource("/resources/sunflower5.png")).getImage();
        ANIM_FRAMES[7] = new ImageIcon(SunFlower.class.getResource("/resources/sunflower2.png")).getImage();
        ANIM_FRAMES[6] = new ImageIcon(SunFlower.class.getResource("/resources/sunflower1.png")).getImage();
        ANIM_FRAMES[5] = new ImageIcon(SunFlower.class.getResource("/resources/sunflower4.png")).getImage();
    }

    private static final Image SPECIAL_IMG = new ImageIcon(SunFlower.class.getResource("/resources/sunflowerS.png")).getImage();

    public SunFlower(int row, int col) {
        super(row, col, 100, 50, 300);
        this.plantImage = MAIN_IMG;
        this.animation = ANIM_FRAMES;
    }

    @Override
    public void performAction(GameEngine engine) {
        Sun newSun = new Sun(row, col * CELLSIZE);
        engine.addProjectile(newSun);
    }

    public void performSpecial(GameEngine engine) {
        for (int i = 0; i < 5; i++) {
            Sun newSun = new Sun(row, col * CELLSIZE);
            engine.addProjectile(newSun);
            this.plantImage = SPECIAL_IMG;
            performedSpecial = true;
        }
    }

    @Override
    public void reloadImage() {
        this.plantImage = MAIN_IMG;
        performedSpecial = false;
        this.animation = ANIM_FRAMES;
    }
}