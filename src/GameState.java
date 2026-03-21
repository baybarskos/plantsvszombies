import java.io.Serializable;
import java.util.List;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;

    public List<Zombies> zombies;
    public List<Plants> plants;
    public List<Projectiles> projectiles;
    public int currentSun;
    public int WaveCount;

    public int performedTotalTime;
    public boolean isWavePhase;
    public int currentPhaseZombiesSpawned;

    public GameState(List<Zombies> z, List<Plants> p, List<Projectiles> proj, int sun, int WaveCount, int performedTotalTime, boolean isWavePhase, int currentPhaseZombiesSpawned) {
        this.zombies = z;
        this.plants = p;
        this.projectiles = proj;
        this.currentSun = sun;
        this.WaveCount = WaveCount;
        this.performedTotalTime = performedTotalTime;
        this.isWavePhase = isWavePhase;
        this.currentPhaseZombiesSpawned = currentPhaseZombiesSpawned;
    }
}