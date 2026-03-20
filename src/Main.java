import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Main extends JFrame {
    private CardLayout cardLayout=new CardLayout();
    private JPanel mainPanel= new JPanel(cardLayout);
    GameEngine engine;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    public Main(){
        setIconImage(new ImageIcon(getClass().getResource("/resources/wallnutS.png")).getImage());
        setTitle("Plants vs Zombies");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        JPanel gameContainer=new JPanel(new BorderLayout());

        TopPanel topPanel=new TopPanel();
        gameContainer.add(topPanel,BorderLayout.NORTH);

        engine=new GameEngine(topPanel,null);
        topPanel.setEngine(engine);
        engine.setMain(this);
        GamePanel gameBoard=new GamePanel(engine);
        engine.setGameBoard(gameBoard);

        GameArea area;
        for(int row=0;row<5;row++){
            for(int col=0;col<9;col++){
                area=new GameArea(row,col,topPanel,engine);
                gameBoard.add(area);
                engine.allGridSquares.add(area);
            }
        }

        gameContainer.add(gameBoard,BorderLayout.CENTER);
        MainMenu menu=new MainMenu(this,engine);
        LoseScreen loseScreen=new LoseScreen(this);
        WinScreen winScreen=new WinScreen(this);
        mainPanel.add(menu,"START");
        mainPanel.add(gameContainer,"GAME");
        mainPanel.add(loseScreen,"LOSE");
        mainPanel.add(winScreen,"WIN");
        add(mainPanel);

        bindPlantKey(KeyEvent.VK_1, "selectPea",    0);
        bindPlantKey(KeyEvent.VK_2, "selectSun",    1);
        bindPlantKey(KeyEvent.VK_3, "selectWall",   2);
        bindPlantKey(KeyEvent.VK_4, "selectSnow",   3);
        bindPlantKey(KeyEvent.VK_5, "selectCherry", 4);
        bindPlantKey(KeyEvent.VK_6, "selectShovel", 5);
        InputMap escInputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap escActionMap = getRootPane().getActionMap();
        escInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escPause");
        escActionMap.put("escPause", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (engine != null && engine.getTopPanel() != null) {
                    engine.getTopPanel().pauseButton.doClick();
                }
            }
        });
        InputMap plantFoodInputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap plantFoodActionMap = getRootPane().getActionMap();
        plantFoodInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0), "PlantFood");
        plantFoodActionMap.put("PlantFood", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (engine != null && engine.getTopPanel() != null&&!engine.isPaused) {
                    engine.getTopPanel().plantFood.doClick();
                }
            }
        });
        pack();
        setLocationRelativeTo(null);

    }
    public void startGame() {
        cardLayout.show(mainPanel, "GAME");
        engine.start();
        pack();
        setLocationRelativeTo(null);
    }
    public void returnToMenu(){
        cardLayout.show(mainPanel,"START");
    }
    public void loseGame(){
        cardLayout.show(mainPanel,"LOSE");
    }
    public void resetGame(){
        engine.resetBoard();
        repaint();
    }
    public void winGame(){
        cardLayout.show(mainPanel,"WIN");
    }
    private void bindPlantKey(int keyCode, String actionName, int buttonIndex) {
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(keyCode, 0), actionName);

        actionMap.put(actionName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (engine != null && !engine.isPaused) {
                    engine.getTopPanel().selectPlantByIndex(buttonIndex);
                }
            }
        });
    }
}
