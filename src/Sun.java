import javax.swing.*;
import java.awt.*;

public class Sun extends Projectiles{
    private static final Image SUN = new ImageIcon(Sun.class.getResource("/resources/sun.png")).getImage();

    public Sun(int row,int col){
        super(row,col,0,false);
        this.projImage=SUN;
    }

    @Override
    public void move() {
    }
    @Override
    public void reloadImage() {
        this.projImage = SUN;
    }
}
