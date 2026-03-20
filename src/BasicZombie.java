import javax.swing.*;
import java.awt.*;

public class BasicZombie extends Zombies{
    BasicZombie(int row,int col){
        super(row,col,100,1,20);
        this.zombieImage=new ImageIcon(getClass().getResource("/resources/basiczombie1.png")).getImage();
        animation=new Image[8];
        animation[0]=new ImageIcon(getClass().getResource("/resources/basiczombie3.png")).getImage();
        animation[1]=new ImageIcon(getClass().getResource("/resources/basiczombie2.png")).getImage();
        animation[2]=new ImageIcon(getClass().getResource("/resources/basiczombie1.png")).getImage();
        animation[3]=new ImageIcon(getClass().getResource("/resources/basiczombie4.png")).getImage();
        animation[4]=new ImageIcon(getClass().getResource("/resources/basiczombie5.png")).getImage();
        animation[7]=new ImageIcon(getClass().getResource("/resources/basiczombie2.png")).getImage();
        animation[6]=new ImageIcon(getClass().getResource("/resources/basiczombie1.png")).getImage();
        animation[5]=new ImageIcon(getClass().getResource("/resources/basiczombie4.png")).getImage();
    }
    @Override
    public void reloadImage() {
        this.zombieImage = new ImageIcon(getClass().getResource("/resources/basiczombie1.png")).getImage();
        animation=new Image[8];
        animation[0]=new ImageIcon(getClass().getResource("/resources/basiczombie3.png")).getImage();
        animation[1]=new ImageIcon(getClass().getResource("/resources/basiczombie2.png")).getImage();
        animation[2]=new ImageIcon(getClass().getResource("/resources/basiczombie1.png")).getImage();
        animation[3]=new ImageIcon(getClass().getResource("/resources/basiczombie4.png")).getImage();
        animation[4]=new ImageIcon(getClass().getResource("/resources/basiczombie5.png")).getImage();
        animation[7]=new ImageIcon(getClass().getResource("/resources/basiczombie2.png")).getImage();
        animation[6]=new ImageIcon(getClass().getResource("/resources/basiczombie1.png")).getImage();
        animation[5]=new ImageIcon(getClass().getResource("/resources/basiczombie4.png")).getImage();
    }
}
