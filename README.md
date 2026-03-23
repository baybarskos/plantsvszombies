Plants vs Zombies clone made in Java with Javax Swing and Java AWT

[Youtube Link](https://youtu.be/NV8BD3rJP-w)

This project is a simplified version of Plants vs Zombies with 4 zombie type and 5 plant type.

The objective is to plant plants on a 5x9 grid to defend against the zombies.
If any zombie touches the leftmost edge, you lose. If you successfully survive all the waves, you win.

Features
* 5 Plant Types: PeaShooter, SunFlower, WallNut, SnowPea, CherryBomb.
* 4 Zombie Types: BasicZombie, FastZombie, RunZombie, TankZombie.
* Dynamic Wave System: A multithreaded spawning system that scales in difficulty, increasing zombie health and spawn frequency as waves progress.
* Save & Load System: The game can be paused at any time, which saves the current state to a file. Players can load this file from the main menu to resume their progress anytime.
* Bonus features:
  * Shovel: Removes a plant from a tile.
  * Plant Food: Triggers temporary superpowers for used plants.
 UI Notation:
  * (number-PlantName): The number before the hyphen indicates the plant's cost
    (e.g., "100-PeaShooter" means PeaShooter costs 100 sun)
  * (number Plant Food): The specified number indicates how many Plant Foods are left to use.

How to Run the Game
You need to have JDK21 to successfully run the game
  Terminal
* 1. Open your terminal and navigate to the project directory: 'cd path/to/directory'
* 2. Compile all .java files: 'javac *.java'
* 3. Run the application: 'java Main'
  Executing .jar file
The project folder includes a pre-packaged .jar file.
* Windows/Mac: Double click the .jar file to run the game.
* Linux: You may need to set the file executable. Right click the .jar file and go to Properties > Permissions and check "Allow    executing file as program" then simply double click the file.

Controls
* Mouse: 
  - Click the buttons in the menus to navigate through game.
  - Click the buttons in the top panel than to the grids to place plants, use shovel or Plant Food on a plant.
  - Click on spawned suns to collect them.
  - Click the "Pause & Save" button in the top panel to pause and save the game. Click "Resume & Load" to resume and load.
* Keyboard Shortcuts:
  - 1 - 5: Select plants for placement.
  - 6: Select the Shovel.
  - 7: Activate PlantFood.
  - ESC: Pause & Save or Resume & Load the game.

