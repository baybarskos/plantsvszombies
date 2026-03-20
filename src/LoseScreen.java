import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoseScreen extends JPanel implements CellSize{
    private Image image;
    LoseScreen(Main main){
        this.image=new ImageIcon(getClass().getResource("/resources/pvzlosescreen.png")).getImage();
        setLayout(new BorderLayout());
        JButton restartButton=new JButton("MAIN MENU");
        restartButton.setForeground(Color.RED);
        restartButton.setFont(new Font("Ariel",Font.BOLD,80));
        restartButton.setPreferredSize(new Dimension(300,80));
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                main.resetGame();
                main.returnToMenu();
            }
        });
        restartButton.setBackground(Color.RED);
        restartButton.setOpaque(false);
        add(restartButton,BorderLayout.SOUTH);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
