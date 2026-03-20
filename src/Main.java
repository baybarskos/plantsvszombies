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
        setTitle("Plants vs Zombies spinoff");
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

        InputMap inputMap=mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap=mainPanel.getActionMap();
        String keyWord="ESC";
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0), keyWord);
        actionMap.put("ESC", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(engine!=null){
                    if(engine.isPaused){
                        engine.resumeAndLoad();
                        topPanel.pauseButton.setBackground(Color.RED);
                    } else {
                        engine.pauseAndSave();
                        topPanel.pauseButton.setBackground(Color.GREEN);
                    }
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
}
