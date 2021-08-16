package org.academiadecodigo.shellmurais.gameobjects.enemies;

import org.academiadecodigo.shellmurais.GameManager;
import org.academiadecodigo.shellmurais.gameobjects.levels.Level1;
import org.academiadecodigo.shellmurais.gameobjects.levels.Levels;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Item extends Enemy {

    private int counterItem;
    private GameManager gameManager;
    private static boolean isItem;


    public Item(int x, int y, String file, GameManager gameManager) {
        rectangle = new Picture(x, y, file);

        this.gameManager = gameManager;
        counterItem = 0;
        isItem = false;
        init();

    }

    @Override
    protected void init() {
        rectangle.draw();

    }

    public void setCounterItem() {
        if (!isItem) {
            counterItem++;
            isItem = true;
            System.out.println(counterItem);
        }

    }

    public int getCounterItem() {
        return counterItem;
    }

    public void setCounterItem(int counterItem) {
        this.counterItem = counterItem;
    }

    @Override
    public void moveEnemyRight() {
        walk(0, 0);

    }

    @Override
    public void moveEnemyLeft() {
        walk(0, 0);

    }

    @Override
    protected void walk(int moveSpeed, int delay) {

    }

    public void deleteItem() {
        rectangle.delete();
    }

}
