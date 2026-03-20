import java.awt.*;

public abstract class Zombies extends GameObject{
    double speed;
    int damage;
    boolean isAttacking;
    double xPosition;
    transient Image zombieImage;
    transient Image[] animation;
    int currentFrame=0;
    int animationTick=0;
    int animationSpeed=10;
    int attackTimer;

    public Zombies(int row,int col,int health,double speed,int damage){
        super(row,col,health); this.speed=speed;this.damage=damage;this.isAttacking=false;
        xPosition=col*CELLSIZE;
    }
    public Image getImage() {
        return zombieImage;
    }

    public int getRow() {
        return this.row;
    }

    public double getXPosition() {
        return this.xPosition;
    }
    public void move() {
        if (!isAttacking) {
            xPosition-=speed/3;
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
    public void attack(Plants target){
            this.isAttacking=true;
            attackTimer++;
            if(attackTimer>=60){
                target.takeDamage(this.damage);
                if(target.isDead()) isAttacking=false;
                attackTimer=0;
            }

    }
    public void applySlowEffect(){
        if(this.speed>0.5) this.speed/=3;
    }
}
