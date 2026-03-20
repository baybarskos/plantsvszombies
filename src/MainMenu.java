import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements CellSize{
    private Image background;
    public MainMenu(Main main, GameEngine engine){
        setLayout(new BorderLayout());
        this.background=new ImageIcon(getClass().getResource("/resources/pvzbackground.png")).getImage();
        Color semiOpaqueColor = new Color(146, 179, 106, 50);
        JButton startButton=new JButton("NEW GAME");
        startButton.setFont(new Font("Arial",Font.BOLD,30));
        startButton.setForeground(Color.WHITE);
        startButton.setPreferredSize(new Dimension(300,80));
        startButton.setBackground(semiOpaqueColor);
        startButton.setBorderPainted(false);
        startButton.setOpaque(true);
        startButton.setFocusPainted(false);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                main.startGame();
                engine.start();
            }
        });
        JButton loadButton=new JButton("LOAD GAME");
        loadButton.setFont(new Font("Dialog",Font.BOLD,30));
        loadButton.setPreferredSize(new Dimension(300,80));
        loadButton.setBackground(semiOpaqueColor);
        loadButton.setForeground(Color.WHITE);
        loadButton.setBorderPainted(false);
        loadButton.setOpaque(true);
        loadButton.setFocusPainted(false);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                main.startGame();
                engine.start();
                engine.isPaused=true;
                engine.resumeAndLoad();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(loadButton);
        buttonPanel.add(startButton);
        add(buttonPanel, BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(CELLSIZE*9,CELLSIZE*5));
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
}