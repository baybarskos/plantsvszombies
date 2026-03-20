import javax.swing.*;
import java.awt.*;

public class WinScreen extends JPanel {
    private Image image;

    public WinScreen(Main mainFrame) {
        setLayout(new BorderLayout());
        setBackground(new Color(50, 200, 50)); // A nice victory green!
        this.image=new ImageIcon(getClass().getResource("/resources/pvzwinscreen.png")).getImage();

        JButton menuButton = new JButton("Play Again");
        menuButton.setFont(new Font("Arial", Font.BOLD, 30));

        menuButton.addActionListener(e -> {
            mainFrame.resetGame();
            mainFrame.returnToMenu();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(menuButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}