package org.academiadecodigo.shellmurais.gameobjects.levels;

import org.academiadecodigo.shellmurais.GameManager;
import org.academiadecodigo.shellmurais.gameobjects.GameObject;
import org.academiadecodigo.shellmurais.gameobjects.enemies.FastEnemy;
import org.academiadecodigo.shellmurais.gameobjects.enemies.Item;
import org.academiadecodigo.shellmurais.gameobjects.enemies.NPC;
import org.academiadecodigo.shellmurais.gameobjects.platform.Platform;
import org.academiadecodigo.shellmurais.gameobjects.player.Player;
import org.academiadecodigo.shellmurais.gameobjects.levels.Levels;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Tutorial extends Levels {

    private int counterItem;
    Picture background;

    public Tutorial(GameManager gm) {
        max = 9;
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
        gameObjects[1] = new FastEnemy(500, 560, 700, 350, "Left", "bug-1.png", gm);
        gameObjects[2] = new FastEnemy(800, 450, 850, 650, "Left", "bug-1.png", gm);
        gameObjects[3] = new Platform(10, 660, "platform.png", gm);
        gameObjects[4] = new Platform(400, 400, "platform-1.png", gm);
        gameObjects[5] = new Platform(500, 400, "platform-1.png", gm);
        gameObjects[6] = new Platform(600, 400, "platform-1.png", gm);
        gameObjects[7] = new Item(1000, 650, "golden-ticket-1.png", gm);
        gameObjects[8] = new NPC(1000, 650, "golden-ticket-1.png");

    }

    @Override
    public void deleteAllObjects() {
        ((Player) gameObjects[0]).deletePlayer();
        ((FastEnemy) gameObjects[1]).deleteEnemy();
        ((FastEnemy) gameObjects[2]).deleteEnemy();
        ((Platform) gameObjects[3]).deletePlatforms();
        ((Platform) gameObjects[4]).deletePlatforms();
        ((Platform) gameObjects[5]).deletePlatforms();
        ((Platform) gameObjects[6]).deletePlatforms();
        ((Item) gameObjects[7]).deleteItem();
        ((NPC) gameObjects[8]).deleteItem();

    }


}


