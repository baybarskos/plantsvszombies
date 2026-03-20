import javax.swing.*;

public class Sun extends Projectiles{
    public Sun(int row,int col){
        super(row,col,0,false);
        this.projImage=new ImageIcon(getClass().getResource("/resources/sun.png")).getImage();
    }

    @Override
    public void move() {
    }
    @Override
    public void reloadImage() {
        this.projImage = new ImageIcon(getClass().getResource("/resources/sun.png")).getImage();
    }
}
