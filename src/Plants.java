import java.awt.*;

public abstract class Plants extends GameObject {
    int cost;
    transient Image plantImage;
    transient Image[] animation;
    int currentFrame=0;
    int animationTick=0;
    int animationSpeed=10;
    int actionTimer;
    int specialAnimationTick=60;
    private int specialActionTimer;
    int personalTimer;
    boolean performedSpecial=false;
    public Plants(int row, int col, int health, int cost,int actionTimer){
        super(row,col,health); this.cost=cost; this.actionTimer=actionTimer; this.specialAnimationTick=60;
    }
    public Plants(int row, int col, int health, int cost,int actionTimer,int specialAnimationTick){
        super(row,col,health); this.cost=cost; this.actionTimer=actionTimer; this.specialAnimationTick=specialAnimationTick;
    }
    public Image getImage(){return plantImage;}
    public void update(GameEngine engine){
        if(performedSpecial){
            specialActionTimer++;
            if(specialActionTimer>specialAnimationTick){
                performedSpecial=false;
                specialActionTimer=0;
            }
        }
        if(actionTimer>0){
            personalTimer++;
            if(personalTimer>=actionTimer){
                performAction(engine);
                personalTimer=0;
            }
        }
        animationTick++;
        if(animationTick>=animationSpeed){
            currentFrame++;
            if(currentFrame>=animation.length){
                currentFrame=0;
            }
            animationTick=0;
        }
    }

    public abstract void performAction(GameEngine engine);
    public abstract void performSpecial(GameEngine engine);
}
