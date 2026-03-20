import java.io.Serializable;
import java.util.List;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;

    public List<Zombies> zombies;
    public List<Plants> plants;
    public List<Projectiles> projectiles;
    public int currentSun;
    public int WaveCount;

    public GameState(List<Zombies> z, List<Plants> p, List<Projectiles> proj, int sun, int WaveCount) {
        this.zombies = z;
        this.plants = p;
        this.projectiles = proj;
        this.currentSun = sun;
        this.WaveCount=WaveCount;
    }
}