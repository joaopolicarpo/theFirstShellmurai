package org.academiadecodigo.shellmurais.gameobjects.levels;

import org.academiadecodigo.shellmurais.GameManager;
import org.academiadecodigo.shellmurais.gameobjects.GameObject;
import org.academiadecodigo.shellmurais.gameobjects.enemies.FastEnemy;
import org.academiadecodigo.shellmurais.gameobjects.enemies.Item;
import org.academiadecodigo.shellmurais.gameobjects.enemies.NPC;
import org.academiadecodigo.shellmurais.gameobjects.platform.Platform;
import org.academiadecodigo.shellmurais.gameobjects.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level1 extends Levels {

    private int counterItem;
    Picture background;

    public Level1(GameManager gm) {
        max = 15;
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
        gameObjects[1] = new FastEnemy(500, 560, 700, 350, "Left", "car-crash.png", gm);
        gameObjects[2] = new FastEnemy(700, 450, 850, 650, "Left", "car-crash.png", gm);
        gameObjects[3] = new FastEnemy(300, 350, 500, 100, "Left", "car-crash.png", gm);
        gameObjects[4] = new FastEnemy(800, 250, 850, 600, "Left", "car-crash.png", gm);
        gameObjects[5] = new Platform(10, 660, "platform.png", gm);
        gameObjects[6] = new Platform(600, 300, "platform-1.png", gm);
        gameObjects[7] = new Platform(700, 300, "platform-1.png", gm);
        gameObjects[8] = new Platform(800, 300, "platform-1.png", gm);
        gameObjects[9] = new Platform(100, 250, "platform-1.png", gm);
        gameObjects[10] = new Platform(200, 450, "platform-1.png", gm);
        gameObjects[11] = new Platform(300, 450, "platform-1.png", gm);
        gameObjects[12] = new Platform(400, 450, "platform-1.png", gm);
        gameObjects[13] = new Item(700, 250, "golden-ticket-1.png", gm);
        gameObjects[14] = new NPC(1100, 560, "mc-paulo.png");

    }

    @Override
    public void deleteAllObjects() {
        ((Player) gameObjects[0]).deletePlayer();
        ((FastEnemy) gameObjects[1]).deleteEnemy();
        ((FastEnemy) gameObjects[2]).deleteEnemy();
        ((FastEnemy) gameObjects[3]).deleteEnemy();
        ((FastEnemy) gameObjects[4]).deleteEnemy();
        ((Platform) gameObjects[5]).deletePlatforms();
        ((Platform) gameObjects[6]).deletePlatforms();
        ((Platform) gameObjects[7]).deletePlatforms();
        ((Platform) gameObjects[8]).deletePlatforms();
        ((Platform) gameObjects[9]).deletePlatforms();
        ((Platform) gameObjects[10]).deletePlatforms();
        ((Platform) gameObjects[11]).deletePlatforms();
        ((Platform) gameObjects[12]).deletePlatforms();
        ((Item) gameObjects[13]).deleteItem();
        ((NPC) gameObjects[14]).deleteItem();
        background.delete();
    }


}

