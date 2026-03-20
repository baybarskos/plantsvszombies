import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TopPanel extends JPanel {
    int currentSun=150;
    JLabel sunLabel;
    private String selectedPlant=null;

    public ArrayList<JButton> plantButtons=new ArrayList<>();

    private final Color DEFAULT=Color.WHITE;
    private final Color SELECTED=Color.LIGHT_GRAY;

    private GameEngine engine;
    public JButton pauseButton;

    int performedTotalTime=0;

    public void setEngine(GameEngine engine){
        this.engine=engine;
    }

    public TopPanel(){
        setLayout(new FlowLayout(FlowLayout.LEFT,16,8));
        setBackground(new Color(220,220,200));
        sunLabel=new JLabel("Sun: "+currentSun);
        sunLabel.setFont(new Font("Arial",Font.BOLD,20));
        add(sunLabel);
        String[] selectables={"PeaShooter","SunFlower","WallNut","SnowPea","CherryBomb","Shovel","PlantFood"};
        for(String plantName:selectables){
            JButton plantButton=new JButton((plantName));

            plantButton.setOpaque(true);
            plantButtons.add(plantButton);

            plantButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedPlant=plantName;
                    highlightSelected(plantButton);
                }
            });
            add(plantButton);
        }

        pauseButton=new JButton("Pause & Save");
        pauseButton.setBackground(Color.RED);
        pauseButton.setForeground(Color.WHITE);
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(engine!=null){
                    if(engine.isPaused) {
                        engine.resumeAndLoad();
                        pauseButton.setText("Pause & Save");
                        pauseButton.setBackground(Color.RED);
                    }else{
                        engine.pauseAndSave();
                        pauseButton.setText("Resume & Load");
                        pauseButton.setBackground(Color.GREEN);
                    }
                }
            }
        });
        add(pauseButton);
    }
    public void addSun(int amount){
        this.currentSun+=amount;
        updateSunDisplay();
    }
    public boolean spendSun(int cost){
        if(this.currentSun>=cost){
            this.currentSun-=cost;
            updateSunDisplay();
            return true;
        }
        return false;
    }
    public void updateSunDisplay(){
        sunLabel.setText("Sun: "+currentSun);
    }
    public String getSelectedPlantName(){
        return selectedPlant;
    }
    public void clearSelection(){
        this.selectedPlant=null;
        highlightSelected(null);
    }
    private void highlightSelected(JButton clicked){
        for(JButton button: plantButtons){
            if(button==clicked) button.setBackground(SELECTED);
            else button.setBackground(DEFAULT);
        }
    }
    public void resetButtons(){
        for(int i=0;i<plantButtons.size();i++){
            plantButtons.get(i).setEnabled(true);
            performedTotalTime=0;
        }
    }
}
