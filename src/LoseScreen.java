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
        restartButton.setFont(new Font("Arial",Font.BOLD,30));
        restartButton.setBackground(new Color(199, 1, 1, 136));
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                main.resetGame();
                main.returnToMenu();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(restartButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
