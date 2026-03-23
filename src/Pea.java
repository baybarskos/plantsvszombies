import javax.swing.*;
import java.awt.*;

public class Pea extends Projectiles{
    private static final Image NORMAL_PEA = new ImageIcon(Pea.class.getResource("/resources/pea.png")).getImage();
    private static final Image SNOW_PEA = new ImageIcon(Pea.class.getResource("/resources/snowpeapea.png")).getImage();

    public Pea(int row,int start, int damage){

        super(row,start,damage,false);
        this.projImage=NORMAL_PEA;
    }
    public void makeSnow(){
        isSnow=true;
        this.projImage=SNOW_PEA;
    }
    @Override
    public void reloadImage() {
        if(!isSnow) this.projImage = NORMAL_PEA;
        else this.projImage=SNOW_PEA;
    }
}
