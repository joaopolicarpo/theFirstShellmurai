package org.academiadecodigo.shellmurais.gameobjects.levels;

import org.academiadecodigo.shellmurais.GameManager;
import org.academiadecodigo.shellmurais.gameobjects.GameObject;
import org.academiadecodigo.shellmurais.gameobjects.enemies.FastEnemy;
import org.academiadecodigo.shellmurais.gameobjects.enemies.Item;
import org.academiadecodigo.shellmurais.gameobjects.enemies.NPC;
import org.academiadecodigo.shellmurais.gameobjects.platform.Platform;
import org.academiadecodigo.shellmurais.gameobjects.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level2 extends Levels {


    private int counterItem;
    Picture background;

    public Level2(GameManager gm) {
        max = 16;
        this.gm = gm;
        gameObjects = new GameObject[max];
        counterItem = 0;
        background = new Picture(10, 10, "background.png");


    }

    public void init() {
        background.draw();
        createGameObjects();

    }


    public void createGameObjects() {
        gameObjects[0] = new Player(20, 560, "man-walk-RIGHT-1.png", gm);
        gameObjects[1] = new FastEnemy(150, 200, 200, 40, "Left", "formula-01.png", gm); //plat
        gameObjects[2] = new FastEnemy(800, 300, 950, 700, "Left", "formula-02.png", gm);
        gameObjects[3] = new FastEnemy(70, 500, 100, 10, "Left", "formula-01.png", gm);
        gameObjects[4] = new FastEnemy(700, 500, 1000, 600, "Left", "formula-01.png", gm);
        gameObjects[5] = new FastEnemy(800, 560, 950, 700, "Left", "formula-02.png", gm);
        gameObjects[6] = new Platform(10, 660, "platform.png", gm);
        gameObjects[7] = new Platform(10, 250, "platform-1.png", gm);
        gameObjects[8] = new Platform(110, 250, "platform-1.png", gm);
        gameObjects[9] = new Platform(600, 350, "platform-1.png", gm);
        gameObjects[10] = new Platform(700, 350, "platform-1.png", gm);
        gameObjects[11] = new Platform(800, 350, "platform-1.png", gm);
        gameObjects[12] = new Platform(900, 350, "platform-1.png", gm);
        gameObjects[13] = new Platform(1080, 180, "platform-1.png", gm);
        gameObjects[14] = new Item(10, 100, "golden-ticket-1.png", gm);
        gameObjects[15] = new NPC(1170, 100, "mc-sara.png");

    }

    @Override
    public void deleteAllObjects() {
        ((Player) gameObjects[0]).deletePlayer();
        ((FastEnemy) gameObjects[1]).deleteEnemy();
        ((FastEnemy) gameObjects[2]).deleteEnemy();
        ((FastEnemy) gameObjects[3]).deleteEnemy();
        ((FastEnemy) gameObjects[4]).deleteEnemy();
        ((FastEnemy) gameObjects[5]).deleteEnemy();
        ((Platform) gameObjects[6]).deletePlatforms();
        ((Platform) gameObjects[7]).deletePlatforms();
        ((Platform) gameObjects[8]).deletePlatforms();
        ((Platform) gameObjects[9]).deletePlatforms();
        ((Platform) gameObjects[10]).deletePlatforms();
        ((Platform) gameObjects[11]).deletePlatforms();
        ((Platform) gameObjects[12]).deletePlatforms();
        ((Platform) gameObjects[13]).deletePlatforms();
        ((Item) gameObjects[14]).deleteItem();
        ((NPC) gameObjects[15]).deleteItem();
        background.delete();

    }

    public GameObject[] getGameObjects() {
        return gameObjects;
    }

}
