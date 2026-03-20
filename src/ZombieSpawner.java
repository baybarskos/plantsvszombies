import java.util.Random;

public class ZombieSpawner implements Runnable{
    private GameEngine engine;
    private boolean running=true;
    private int CurrentWave=1;
    private final int TOTAL_WAVES=2;
    private Random random=new Random();
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
                for(int i=0;i<8;i++){
                    if(!running) return;
                    spawnNormalZombie();
                    Thread.sleep(random.nextInt(3000,5000));
                }
                Thread.sleep(400);
                int zombiesInWave=10+(CurrentWave*5);
                int spawnDelay=3000-(CurrentWave*400);
                for (int i = 0; i < zombiesInWave; i++) {
                    if(!running) return;
                    spawnWaveZombie();
                    Thread.sleep(spawnDelay);
                }

                System.out.println("--- Wave " + CurrentWave + " Complete! ---");
                CurrentWave++;
                Thread.sleep(500 ); 
            }

            
            if (running) {
                System.out.println("ALL WAVES SPAWNED!");
                engine.setAllWavesSpawned(true);
            }
        } catch (Exception e) {
            System.out.println("noooo"+e.getMessage());
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

