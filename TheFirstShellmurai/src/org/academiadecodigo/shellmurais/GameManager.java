package org.academiadecodigo.shellmurais;

import org.academiadecodigo.shellmurais.gameobjects.GameObject;
import org.academiadecodigo.shellmurais.gameobjects.levels.*;
import org.academiadecodigo.shellmurais.gameobjects.enemies.FastEnemy;
import org.academiadecodigo.shellmurais.gameobjects.enemies.Item;
import org.academiadecodigo.shellmurais.gameobjects.enemies.NPC;
import org.academiadecodigo.shellmurais.gameobjects.platform.Platform;
import org.academiadecodigo.shellmurais.gameobjects.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameManager {

    private int maxLevels = 4;
    private int maxObjects = 9;
    private boolean allAlive = true;
    private MenuStage menuStage;
    private boolean gameOver = false;
    private int gameState = 0;
    private Picture gameOverImg;
    private boolean objectCollected = false;
    private boolean questCompleted = false;
    private boolean menuOpen = false;
    private boolean gameStarted = false;
    private int level = 0;
    private Picture winPic = new Picture(10, 10, "game-win.png");


    public Levels[] levels = new Levels[maxLevels];

    Thread oneThreadyBoy = new Thread(new Runnable() {
        @Override
        public void run() {
            //moveAll();
            while (true) {
                runGame();
            }

        }

    });


    public GameManager(int maxLevels)/*throws Exception*/ {
        this.maxLevels = maxLevels;
        levels[0] = new Tutorial(this);
        levels[1] = new Level1(this);
        levels[2] = new Level2(this);
        levels[3] = new Level3(this);
        menuStage = new MenuStage(this);

    }

    public void init()

    {
        gameOver = false;

        oneThreadyBoy.start();
    }

    public void levelInit() {
        levels[level].init();
        gameStarted = true;
    }

    public void runGame() {
        switch (gameState) {
            case 0:
                // Menu
                if (!menuOpen) {
                    startMenu();
                }
                break;
            case 1:
                menuOpen = false;
                // Game
                if (!gameStarted) {
                    levelInit();
                } else {
                    moveAll();
                }

                break;
            default:
                break;

        }

    }

    public void startMenu() {
        menuStage.draw();
        menuOpen = true;
    }

    public void moveAll() {

        GameObject[] gameObjects = levels[level].getGameObjects();
        Player player = (Player) gameObjects[0];


        for (GameObject gameObject : gameObjects) {

            if (gameObject instanceof Platform) {
                continue;
            }
            if (!gameObject.isMoving()) {
                continue;
            }

            if (gameObject instanceof FastEnemy) {

                if (((FastEnemy) gameObject).getDirection().equals("Right")) {
                    ((FastEnemy) gameObject).moveEnemyRight();

                } else {
                    ((FastEnemy) gameObject).moveEnemyLeft();

                }
                ((FastEnemy) gameObject).verifyDirection();

            }


        }

        checkAllCollisions();
        player.applyGravity();
        if (questCompleted) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("fudeu");
            }

            objectCollected = false;
            questCompleted = false;
            levels[level].deleteAllObjects();
            level++;

            if (level <= 3) {
                levelInit();
            } else {
                winPic.draw();
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println("Error image");
                }

                winPic.delete();
                // Send to menu and restart variables
                level = 0;
                setGameState(0);
                setGameStarted(false);
            }
        }

    }

    public void checkAllCollisions() {
        GameObject[] gameObjects = levels[level].getGameObjects();
        boolean playerCollided = false;
        Player player = (Player) gameObjects[0];

        for (GameObject gameObject2 : gameObjects) {
            if (!(gameObject2 instanceof Player)) {

                if (player.collision(gameObject2)) {
                    playerCollided = true;

                    if (gameObject2 instanceof FastEnemy) {
                        restartLevel(player);
                    } else if (gameObject2 instanceof Item) {
                        objectCollected = true;
                        ((Item) gameObject2).deleteItem();

                    } else if (gameObject2 instanceof NPC && objectCollected) {
                        questCompleted = true;
                    } else if (gameObject2 instanceof Platform) {
                        player.setOnGround(true);
                        player.setIsCollided(true);
                    }
                }
            }
        }

        if (!playerCollided) {
            player.setOnGround(false);
            player.setIsCollided(false);
        }

    }

    public void restartLevel(Player player) {
        gameOverImg = new Picture(10, 10, "game-over.png");
        gameOverImg.draw();
        System.out.println("teste");
        try {
            Thread.sleep(1000);
            System.out.println("OIIII");
        } catch (Exception e) {
            System.out.println("Error image");
        }
        gameOverImg.delete();
        player.relocate();

    }

    public void deleteObj() {
        levels[level].deleteAllObjects();

    }

    public void gameOver() {
        //System.exit(0);
        setGameState(0);
    }

    public void setGameState(int state) {
        System.out.println("gameObjects" + levels);
        gameState = state;
    }

    public void setGameStarted(boolean gs) {
        gameStarted = gs;
    }


}