import java.util.Random;

public class ZombieSpawner implements Runnable{
    private GameEngine engine;
    private boolean running=true;
    private int CurrentWave=1;
    private final int TOTAL_WAVES=2;
    private Random random=new Random();
    public boolean isWavePhase = false;
    public int currentPhaseZombiesSpawned = 0;
    public ZombieSpawner(GameEngine engine){
        this.engine=engine;
    }
    public int getWaveCount(){
        return CurrentWave;
    }
    public void setWaveCount(int WaveCount){
        this.CurrentWave=WaveCount;
    }
    public void run(){
        try{
            while(running&&CurrentWave<=TOTAL_WAVES){
                if (!isWavePhase) {
                    for (int i = currentPhaseZombiesSpawned; i < 8; i++) {
                        if (!running) return;
                        currentPhaseZombiesSpawned = i;
                        spawnNormalZombie();
                        Thread.sleep(random.nextInt(3000, 5000));
                    }
                    isWavePhase = true;
                    currentPhaseZombiesSpawned = 0;
                    Thread.sleep(2000);
                }
                if (isWavePhase) {
                    int zombiesInWave = 10 + (CurrentWave * 10);
                    int spawnDelay = 3000 - (CurrentWave * 500);

                    for (int i = currentPhaseZombiesSpawned; i < zombiesInWave; i++) {
                        if (!running) return;
                        currentPhaseZombiesSpawned = i;
                        spawnWaveZombie();
                        Thread.sleep(spawnDelay);
                    }
                    CurrentWave++;
                    isWavePhase = false;
                    currentPhaseZombiesSpawned = 0;
                    Thread.sleep(2000);
                }
            }

            
            if (running) {
                engine.setAllWavesSpawned(true);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private void spawnNormalZombie(){
        int row=random.nextInt(5);
        int col=9;
        Zombies z=null;
        if(random.nextBoolean()){
            z=new BasicZombie(row,col);
        }
        else{
            z=new FastZombie(row,col);
        }
        engine.addZombie(z);
    }
    private void spawnWaveZombie() {
        int row = random.nextInt(5);
        int col = 9;

        Zombies z=null;
        int type = random.nextInt(4); 

        
        switch (type) {
            case 0: z = new BasicZombie(row, col); break;
            case 1: z = new FastZombie(row, col); break;
            case 2: z = new RunZombie(row, col); break;
            default: z = new TankZombie(row, col); break;
        }

        
        z.health += (CurrentWave * 50);

        engine.addZombie(z);
    }

   
    public void stop() {
        running = false;
    }
}

