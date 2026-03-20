import javax.swing.*;
import java.awt.*;

public class Pea extends Projectiles{

    public Pea(int row,int start, int damage){

        super(row,start,damage,false);
        this.projImage=new ImageIcon(getClass().getResource("/resources/pea.png")).getImage();
    }
    public void makeSnow(){
        isSnow=true;
        this.projImage=new ImageIcon(getClass().getResource("/resources/snowpeapea.png")).getImage();
    }
    @Override
    public void reloadImage() {
        if(!isSnow) this.projImage = new ImageIcon(getClass().getResource("/resources/pea.png")).getImage();
        else this.projImage=new ImageIcon((getClass().getResource("/resources/snowpeapea.png"))).getImage();
    }
}
