import java.io.Serializable;

public abstract class GameObject implements Serializable,CellSize {
    int row;
    int col;
    int health;
    public GameObject(int row,int col,int health){
        this.row=row;this.col=col;this.health=health;
    }
    public void takeDamage(int damage){
        this.health-=damage;
    }
    public boolean isDead(){
        return this.health<=0;
    }
    public abstract void reloadImage();
}
