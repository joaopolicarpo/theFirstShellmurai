package org.academiadecodigo.shellmurais.gameobjects.levels;

import org.academiadecodigo.shellmurais.GameManager;
import org.academiadecodigo.shellmurais.gameobjects.GameObject;
import org.academiadecodigo.shellmurais.gameobjects.enemies.FastEnemy;
import org.academiadecodigo.shellmurais.gameobjects.enemies.Item;
import org.academiadecodigo.shellmurais.gameobjects.enemies.NPC;
import org.academiadecodigo.shellmurais.gameobjects.platform.Platform;
import org.academiadecodigo.shellmurais.gameobjects.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level3 extends Levels {

    private int counterItem;
    Picture background;

    public Level3(GameManager gm) {
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
        gameObjects[1] = new FastEnemy(500, 460, 700, 350, "Left", "mc-pedro-mau.png", gm);
        gameObjects[2] = new FastEnemy(700, 450, 850, 650, "Left", "mc-pedro-mau.png", gm);
        gameObjects[3] = new FastEnemy(300, 280, 450, 100, "Left", "mc-pedro-mau.png", gm);
        gameObjects[4] = new FastEnemy(800, 180, 1000, 700, "Left", "mc-pedro-mau.png", gm);
        gameObjects[5] = new FastEnemy(1000, 300, 1150, 980, "Left", "mc-pedro-mau.png", gm);
        gameObjects[6] = new Platform(10, 660, "platform.png", gm);
        gameObjects[7] = new Platform(600, 300, "platform-1.png", gm);
        gameObjects[8] = new Platform(700, 300, "platform-1.png", gm);
        gameObjects[9] = new Platform(800, 300, "platform-1.png", gm);
        gameObjects[10] = new Platform(100, 400, "platform-1.png", gm);
        gameObjects[11] = new Platform(200, 400, "platform-1.png", gm);
        gameObjects[12] = new Platform(1080, 150, "platform-1.png", gm);
        gameObjects[13] = new Item(1120, 60, "golden-ticket-1.png", gm);
        gameObjects[14] = new NPC(1100, 540, "mc-pedro-bom.png");

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
        ((Item) gameObjects[13]).deleteItem();
        ((NPC) gameObjects[14]).deleteItem();
        background.delete();
    }


}

