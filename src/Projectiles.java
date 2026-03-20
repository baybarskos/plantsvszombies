import java.awt.*;

public abstract class Projectiles extends GameObject{
    int xPosition,damage;
    boolean isSnow;
    transient Image projImage;
    public Projectiles(int row,int start,int damage,boolean isSnow){
        super(row,start/CELLSIZE,1);
        this.xPosition=start;
        this.damage=damage;
        this.isSnow=isSnow;
    }
    public void move(){
        if(health>0){
            xPosition+=5;
        }
    }
    public void hitZombie(Zombies target){
        if(health>0){
            target.takeDamage(this.damage);
            if(this.isSnow){
                target.applySlowEffect();
            }
            this.health=0;
        }
    }
    public Image getImage() {
        return projImage;
    }

    public int getRow() {
        return this.row;
    }

    public int getXPosition() {
        return this.xPosition;
    }
}
