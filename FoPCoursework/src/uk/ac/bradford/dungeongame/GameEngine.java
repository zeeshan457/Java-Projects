package uk.ac.bradford.dungeongame;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * The GameEngine class is responsible for managing information about the game,
 * creating levels, the player and monsters, as well as updating information
 * when a key is pressed while the game is running.
 *
 * @author prtrundl
 */
public class GameEngine {

    /**
     * An enumeration type to represent different types of tiles that make up a
     * dungeon level. Each type has a corresponding image file that is used to
     * draw the right tile to the screen for each tile in a level. Floors are
     * open for monsters and the player to move into, walls should be
     * impassable, stairs allow the player to progress to the next level of the
     * dungeon, and chests can yield a reward when moved over.
     */
    public enum TileType {
        STAIRS, FLOOR, CHEST, WALL
    }

    /**
     * The width of the dungeon level, measured in tiles. Changing this may
     * cause the display to draw incorrectly, and as a minimum the size of the
     * GUI would need to be adjusted.
     */
    public static final int DUNGEON_WIDTH = 25;

    /**
     * The height of the dungeon level, measured in tiles. Changing this may
     * cause the display to draw incorrectly, and as a minimum the size of the
     * GUI would need to be adjusted.
     */
    public static final int DUNGEON_HEIGHT = 18;

    /**
     * The maximum number of monsters that can be generated on a single level of
     * the dungeon. This attribute can be used to fix the size of an array (or
     * similar) that will store monsters.
     */
    public static final int MAX_MONSTERS = 5;

    /**
     * The chance of a wall being generated instead of a floor when generating
     * the level. 1.0 is 100% chance, 0.0 is 0% chance.
     */
    public static final double WALL_CHANCE = 0.05;

    /**
     * A random number generator that can be used to include randomised choices
     * in the creation of levels, in choosing places to spawn the player and
     * monsters, and to randomise movement and damage. This currently uses a
     * seed value of 123 to generate random numbers - this helps you find bugs
     * by giving you the same numbers each time you run the program. Remove the
     * seed value if you want different results each game.
     */
    private Random rng = new Random(123);

    /**
     * The current level number for the dungeon. As the player moves down stairs
     * the level number should be increased and can be used to increase the
     * difficulty e.g. by creating additional monsters with more health.
     */
    private int depth = 1;  //current dunegeon level

    /**
     * The GUI associated with a GameEngine object. THis link allows the engine
     * to pass level (tiles) and entity information to the GUI to be drawn.
     */
    private GameGUI gui;

    /**
     * The 2 dimensional array of tiles the represent the current dungeon level.
     * The size of this array should use the DUNGEON_HEIGHT and DUNGEON_WIDTH
     * attributes when it is created.
     */
    private TileType[][] tiles;

    /**
     * An ArrayList of Point objects used to create and track possible locations
     * to spawn the player and monsters.
     */
    private ArrayList<Point> spawns;

    /**
     * An Entity object that is the current player. This object stores the state
     * information for the player, including health and the current position
     * (which is a pair of co-ordinates that corresponds to a tile in the
     * current level)
     */
    private Entity player;

    /**
     * An array of Entity objects that represents the monsters in the current
     * level of the dungeon. Elements in this array should be of the type
     * Entity, meaning that a monster is alive and needs to be drawn or moved,
     * or should be null which means nothing is drawn or processed for movement.
     * Null values in this array are skipped during drawing and movement
     * processing. Monsters (Entity objects) that die due to player attacks can
     * be replaced with the value null in this array which removes them from the
     * game.
     */
    public Entity[] monsters;

    /**
     * Constructor that creates a GameEngine object and connects it with a
     * GameGUI object.
     *
     * @param gui The GameGUI object that this engine will pass information to
     * in order to draw levels and entities to the screen.
     */
    public GameEngine(GameGUI gui) {
        this.gui = gui;
    }

    /**
     * Generates a new dungeon level. The method builds a 2D array of TileType
     * values that will be used to draw tiles to the screen and to add a variety
     * of elements into each level. Tiles can be floors, walls, stairs (to
     * progress to the next level of the dungeon) or chests. The method should
     * contain the implementation of an algorithm to create an interesting and
     * varied level each time it is called.
     *
     * @return A 2D array of TileTypes representing the tiles in the current
     * level of the dungeon. The size of this array should use the width and
     * height of the dungeon.
     */
    private TileType[][] generateLevel() {                                       //map  

        TileType[][] Tile = new TileType[DUNGEON_WIDTH][DUNGEON_HEIGHT];
        //RANDOM TILE
        int randomTile = new Random().nextInt(TileType.values().length + 10);

        //TILE MAP
        for (int i = 0; i < Tile.length; i++) {
            for (int j = 0; j < Tile[j].length; j++) {
                Tile[i][j] = TileType.FLOOR;

                //CREATING LARGE WALL / CHANGING VALUES HERE WILL AFFECT THE FLOOR TILES! 
                for (int x = 1; x < rng.nextInt(TileType.values().length) + 20; x++) {
                    for (int y = 1; y < rng.nextInt(TileType.values().length) + 12; y++) {

                        //RANDMISE THE WALL (OPTION) * 100 (looks messy)
                        if (WALL_CHANCE > (int) (Math.random())) {
                            //VALUES FROM 0-1 ARE STAIRS, 1-2 ARE CHESTS, 2-3 ARE WALLS 3-4 IS LAVA)
                            Tile[x][y] = TileType.values()[(int) (Math.random() + 3.2)];

                            //WIDTH
                            switch (y) {
                                case 1:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 3:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 5:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 7:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 9:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 11:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 13:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 15:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;

                            }

                            //HEIGHT
                            switch (x) {
                                case 1:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 3:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 5:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 7:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 9:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 11:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 13:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 15:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 17:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 19:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 21:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                                case 23:
                                    Tile[x][y] = TileType.FLOOR;
                                    break;
                            }
                        }

                        //PLAYER TILE, STAIRS AND CHEST
                        Tile[22][14] = TileType.STAIRS;
                        Tile[1][1] = TileType.FLOOR;
                        Tile[2][14] = TileType.CHEST;

                        //HEIGHT BORDER
                        if (i == 0 | i == DUNGEON_HEIGHT + 6) {
                            Tile[i][j] = TileType.WALL;

                            //WIDTH BORDER
                        } else if (j == 0 | j == DUNGEON_WIDTH - 8) {
                            Tile[i][j] = TileType.WALL;
                        } else if (j == 0 | j == DUNGEON_WIDTH - 9) {
                            Tile[i][j] = TileType.WALL;

                        }

                    }
                }
            }

        }

//RETURN THE 2D ARRAY
        return Tile;

    }

    /**
     * Generates spawn points for the player and monsters. The method processes
     * the tiles array and finds tiles that are suitable for spawning, i.e.
     * tiles that are not walls or stairs. Suitable tiles should be added to the
     * ArrayList that will contain Point objects - Points are a simple kind of
     * object that contain an X and a Y co-ordinate stored using the int
     * primitive type and are part of the Java language (search for the Point
     * API documentation and examples of their use)
     *
     * @return An ArrayList containing Point objects representing suitable X and
     * Y co-ordinates in the current level that the player or monsters can be
     * spawned in
     */
    private ArrayList<Point> getSpawns() {

        //MY SPAWNS WERE FLOOR TILES
        ArrayList<Point> s = new ArrayList<>();
        return s;

    }

    /**
     * Spawns monsters in suitable locations in the current level. The method
     * uses the spawns ArrayList to pick suitable positions to add monsters,
     * removing these positions from the spawns ArrayList as they are used
     * (using the remove() method) to avoid multiple monsters spawning in the
     * same location. The method creates monsters by instantiating the Entity
     * class, setting health, and setting the X and Y position for the monster
     * using the X and Y values in the Point object removed from the spawns
     * ArrayList.
     *
     * @return A array of Entity objects representing the monsters for the
     * current level of the dungeon
     */
    private Entity[] spawnMonsters() {                                           //monster

        Entity[] monsters = new Entity[MAX_MONSTERS];

        //EASY MONSTERS
        monsters[0] = new Entity(30, 22, 15, Entity.EntityType.MONSTER);
        monsters[1] = new Entity(30, 23, 14, Entity.EntityType.MONSTER);

        for (Entity monster : monsters) {
            if (monster != null) {

                // IF SPAWN IN WALL, IT WILL SPAWN TO NEAREST FLOOR TILE
                int spawn = rng.nextInt(4);
                //LEFT SIDE SPAWN
                switch (spawn) {
                    case 0:
                        if (tiles[monster.getX()][monster.getY()] == TileType.WALL) {
                            if (tiles[monster.getX() - 2][monster.getY()] == TileType.FLOOR) {
                                monster.setPosition(monster.getX() - 2, monster.getY());
                            }
                            break;
                        }
                    case 1:
                        if (tiles[monster.getX()][monster.getY()] == TileType.WALL) {
                            if (tiles[monster.getX() - 1][monster.getY()] == TileType.FLOOR) {
                                monster.setPosition(monster.getX() - 1, monster.getY());
                            }
                            break;
                        }
                    //UPPER SIDE SPAWN
                    case 2:
                        if (tiles[monster.getX()][monster.getY()] == TileType.WALL) {
                            if (tiles[monster.getX()][monster.getY() - 2] == TileType.FLOOR) {
                                monster.setPosition(monster.getX(), monster.getY() - 2);
                            }
                            break;
                        }
                    case 4:
                        if (tiles[monster.getX()][monster.getY()] == TileType.WALL) {
                            if (tiles[monster.getX()][monster.getY() - 1] == TileType.FLOOR) {
                                monster.setPosition(monster.getX(), monster.getY() - 1);
                            }
                        }
                }
            }
            break;
        }

        //RETURN MONSTERS
        return monsters;
    }

    /**
     * Spawns a player entity in the game. The method uses the spawns ArrayList
     * to select a suitable location to spawn the player and removes the Point
     * from the spawns ArrayList. The method instantiates the Entity class and
     * assigns values for the health, position and type of Entity.
     *
     * @return An Entity object representing the player in the game
     */
    private Entity spawnPlayer() {
        Entity Player = new Entity(25, 1, 1, Entity.EntityType.PLAYER);

        return Player;
    }

    /**
     * Handles the movement of the player when attempting to move left in the
     * game. This method is called by the DungeonInputHandler class when the
     * user has pressed the left arrow key on the keyboard. The method checks
     * whether the tile to the left of the player is empty for movement and if
     * it is updates the player object's X and Y locations with the new
     * position. If the tile to the left of the player is not empty the method
     * will not update the player position, but may make other changes to the
     * game, such as damaging a monster in the tile to the left, or breaking a
     * wall etc.
     */
    public void movePlayerLeft() {
        if (null != tiles[player.getX() - 1][player.getY()]) {
            switch (tiles[player.getX() - 1][player.getY()]) {

                case FLOOR:
                    player.setPosition(player.getX() - 1, player.getY());
                    break;

                case STAIRS:
                    player.setPosition(player.getX() - 1, player.getY());
                    break;

                default:
                    break;

            }
        }

    }

    /**
     * Handles the movement of the player when attempting to move right in the
     * game. This method is called by the DungeonInputHandler class when the
     * user has pressed the right arrow key on the keyboard. The method checks
     * whether the tile to the right of the player is empty for movement and if
     * it is updates the player object's X and Y locations with the new
     * position. If the tile to the right of the player is not empty the method
     * will not update the player position, but may make other changes to the
     * game, such as damaging a monster in the tile to the right, or breaking a
     * wall etc.
     */
    public void movePlayerRight() {
        if (null != tiles[player.getX() + 1][player.getY()]) {
            switch (tiles[player.getX() + 1][player.getY()]) {

                case FLOOR:
                    player.setPosition(player.getX() + 1, player.getY());
                    break;

                case STAIRS:
                    player.setPosition(player.getX() + 1, player.getY());
                    break;

                default:
                    break;
            }
        }

    }

    /**
     * Handles the movement of the player when attempting to move up in the
     * game. This method is called by the DungeonInputHandler class when the
     * user has pressed the up arrow key on the keyboard. The method checks
     * whether the tile above the player is empty for movement and if it is
     * updates the player object's X and Y locations with the new position. If
     * the tile above the player is not empty the method will not update the
     * player position, but may make other changes to the game, such as damaging
     * a monster in the tile above the player, or breaking a wall etc.
     */
    public void movePlayerUp() {
        if (null != tiles[player.getX()][player.getY() - 1]) {
            switch (tiles[player.getX()][player.getY() - 1]) {

                case FLOOR:
                    player.setPosition(player.getX(), player.getY() - 1);
                    break;

                case STAIRS:
                    player.setPosition(player.getX(), player.getY() - 1);
                    break;

                default:
                    break;
            }
        }

    }

    /**
     * Handles the movement of the player when attempting to move right in the
     * game. This method is called by the DungeonInputHandler class when the
     * user has pressed the down arrow key on the keyboard. The method checks
     * whether the tile below the player is empty for movement and if it is
     * updates the player object's X and Y locations with the new position. If
     * the tile below the player is not empty the method will not update the
     * player position, but may make other changes to the game, such as damaging
     * a monster in the tile below the player, or breaking a wall etc.
     */
    public void movePlayerDown() {
        if (null != tiles[player.getX()][player.getY() + 1]) {
            switch (tiles[player.getX()][player.getY() + 1]) {

                case FLOOR:
                    player.setPosition(player.getX(), player.getY() + 1);
                    break;

                case CHEST:
                    player.setPosition(player.getX(), player.getY() + 1);
                    player.changeHealth(+5);
                    break;

                case STAIRS:
                    player.setPosition(player.getX(), player.getY() + 1);
                    break;

                default:
                    break;
            }
        }

    }

    /**
     * Reduces a monster's health in response to the player attempting to move
     * into the same square as the monster (attacking the monster).
     *
     * @param m The Entity which is the monster that the player is attacking
     */
    private void hitMonster(Entity m) {

        for (Entity monster : monsters) {
            monster = m;
            monster.changeHealth(-2);
        }
    }

    /**
     * Moves all monsters on the current level. The method processes all
     * non-null elements in the monsters array and calls the moveMonster method
     * for each one.
     */
    private void moveMonsters() {

        for (Entity monster : monsters) {
            if (monster != null) {
                moveMonster(monster);
            }
        }
    }

    /**
     * Moves a specific monster in the game. The method updates the X and Y
     * attributes of the monster Entity to reflect its new position.
     *
     * @param m The Entity (monster) that needs to be moved
     */
    private void moveMonster(Entity m) {
        for (Entity monster : monsters) {
            monster = m;
            Random rnd = new Random();

            //ONLY MOVES NON-NULL MONSTERS
            if (monster != null) {

                //MOVING DISTANCE
                for (int move = 0; move < 2; move++) {

                    //MOVE MONSTER RANDOM
                    int randommove = rnd.nextInt(4);
                    switch (randommove) {

                        case 0:
                            //FOLLOW PLAYER
                            if (tiles[monster.getX()][monster.getY() - 1] == TileType.FLOOR) {
                                if (monster.getY() > player.getY()) {

                                    monster.setPosition(monster.getX(), monster.getY() - 1);

                                    //ATTACK PLAYER
                                    if (monster.getX() == player.getX() && monster.getY() == player.getY()) {
                                        hitPlayer();
                                    }
                                }
                            }
                            break;

                        case 1:
                            //FOLLOW PLAYER
                            if (tiles[monster.getX()][monster.getY() + 1] == TileType.FLOOR) {
                                if (monster.getY() < player.getY()) {

                                    monster.setPosition(monster.getX(), monster.getY() + 1);

                                    //ATTACK PLAYER
                                    if (monster.getX() == player.getX() && monster.getY() == player.getY()) {
                                        hitPlayer();
                                    }
                                }
                            }
                            break;

                        case 2:
                            //FOLLOW PLAYER
                            if (tiles[monster.getX() - 1][monster.getY()] == TileType.FLOOR) {
                                if (monster.getX() > player.getX()) {

                                    monster.setPosition(monster.getX() - 1, monster.getY());

                                    //ATTACK PLAYER
                                    if (monster.getX() == player.getX() && monster.getY() == player.getY()) {
                                        hitPlayer();
                                    }
                                }
                            }
                            break;

                        case 3:
                            //FOLLOW PLAYER
                            if (tiles[monster.getX() + 1][monster.getY()] == TileType.FLOOR) {
                                if (monster.getX() < player.getX()) {

                                    monster.setPosition(monster.getX() + 1, monster.getY());

                                    //ATTACK PLAYER
                                    if (monster.getX() == player.getX() && monster.getY() == player.getY()) {
                                        hitPlayer();

                                    }
                                }
                            }
                    }
                }
            }

            break;

        }

    }

    /**
     * Reduces the health of the player when hit by a monster - a monster next
     * to the player can attack it instead of moving and should call this method
     * to reduce the player's health
     */
    private void hitPlayer() {
        player.changeHealth(-2);
    }

    /**
     * Processes the monsters array to find any Entity in the array with 0 or
     * less health. Any Entity in the array with 0 or less health should be set
     * to null; when drawing or moving monsters the null elements in the
     * monsters array are skipped.
     */
    public void cleanDeadMonsters() {

        for (Entity monster : monsters) {
            if (monster != null) {
                if (monster.getHealth() < 1) {
                    monsters[0] = null;
                    monsters[1] = null;
                    monsters[2] = null;


                }
            }
        }

    }
//@JsonSetter(contentNulls = Nulls.SKIP)

    /**
     * Called in response to the player moving into a Stair tile in the game.
     * The method increases the dungeon depth, generates a new level by calling
     * the generateLevel method, fills the spawns ArrayList with suitable spawn
     * locations and spawns monsters. Finally it places the player in the new
     * level by calling the placePlayer() method. Note that a new player object
     * should not be created here unless the health of the player should be
     * reset.
     */
    private void descendLevel() {
        depth++;

        //MORE DEPTH = HARDER MONSTERS
        if (depth >= 2) {
            if (monsters[0] == null) {
                tiles = generateLevel();
                switch (depth) {
                    case 2:
                        player.setPosition(1, 1);
                        monsters[0] = new Entity(50, 22, 15, Entity.EntityType.MONSTER);
                        monsters[1] = new Entity(50, 23, 14, Entity.EntityType.MONSTER);

                        break;
                    case 3:
                        player.setPosition(1, 1);
                        monsters[0] = new Entity(60, 22, 15, Entity.EntityType.MONSTER);
                        monsters[1] = new Entity(60, 23, 14, Entity.EntityType.MONSTER);
                        break;
                    case 4:
                        player.setPosition(1, 1);
                        monsters[0] = new Entity(70, 22, 15, Entity.EntityType.MONSTER);
                        monsters[1] = new Entity(70, 23, 14, Entity.EntityType.MONSTER);
                        break;
                    case 5:
                        player.setPosition(1, 1);
                        monsters[0] = new Entity(80, 22, 15, Entity.EntityType.MONSTER);
                        monsters[1] = new Entity(80, 23, 14, Entity.EntityType.MONSTER);
                        break;
                    case 6:
                        player.setPosition(1, 1);
                        monsters[0] = new Entity(90, 22, 15, Entity.EntityType.MONSTER);
                        monsters[1] = new Entity(90, 23, 14, Entity.EntityType.MONSTER);
                        monsters[2] = new Entity(90, 21, 14, Entity.EntityType.MONSTER);
                        break;
                    default:
                        System.exit(0);
                        break;
                }
            }

        }
    }

    /**
     * Places the player in a dungeon level by choosing a spawn location from
     * the spawns ArrayList, removing the spawn position as it is used. The
     * method sets the players position in the level by calling its setPosition
     * method with the x and y values of the Point taken from the spawns
     * ArrayList.
     */
    private void placePlayer() {
        Entity newPlayer = new Entity(25, 1, 1, Entity.EntityType.PLAYER);

    }

    /**
     * Performs a single turn of the game when the user presses a key on the
     * keyboard. The method cleans dead monsters, moves any monsters still alive
     * and then checks if the player is dead, exiting the game or resetting it
     * after an appropriate output to the user is given. It checks if the player
     * moved into a stair tile and calls the descendLevel method if it does.
     * Finally it requests the GUI to redraw the game level by passing it the
     * tiles, player and monsters for the current level.
     */
    public void doTurn() {
        cleanDeadMonsters();
        moveMonsters();
        if (player != null) {       //checks a player object exists
            if (player.getHealth() < 1) {
                System.exit(0);     //exits the game when player is dead
            }
            if (tiles[player.getX()][player.getY()] == TileType.STAIRS) {
                descendLevel();     //moves to next level if the player is on Stairs
            }
        }
        gui.updateDisplay(tiles, player, monsters);     //updates GUI
    }

    /**
     * Starts a game. This method generates a level, finds spawn positions in
     * the level, spawns monsters and the player and then requests the GUI to
     * update the level on screen using the information on tiles, player and
     * monsters.
     */
    public void startGame() {
        tiles = generateLevel();
        spawns = getSpawns();
        monsters = spawnMonsters();
        player = spawnPlayer();
        gui.updateDisplay(tiles, player, monsters);
    }
}
