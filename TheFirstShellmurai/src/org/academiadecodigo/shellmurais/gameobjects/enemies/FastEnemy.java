package org.academiadecodigo.shellmurais.gameobjects.enemies;

import org.academiadecodigo.shellmurais.GameManager;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FastEnemy extends Enemy {

    private GameManager gameManager;
    private int limitRight;
    private int limitLeft;

    public FastEnemy(int x, int y, int limitRight, int limitLeft, String direction, String file, GameManager gameManager) {
        rectangle = new Picture(x, y, file);
        this.direction = direction;
        this.gameManager = gameManager;
        this.limitRight = limitRight;
        this.limitLeft = limitLeft;
        init();

    }

    @Override
    protected void init() {
        rectangle.draw();

    }

    @Override
    public void moveEnemyRight()  {
        walk(1, 5);

    }

    @Override
    public void moveEnemyLeft()  {
        walk(-1, 5);

    }

    @Override
    protected void walk(int moveSpeed, int delay)  {
        try {
            //System.out.println("Moving fast...");
            Thread.sleep(delay);
        } catch (Exception e) {
            System.out.println("ERRO");
        }

        rectangle.translate(moveSpeed, 0);

    }

    public int getLimitRight() {
        return limitRight;
    }

    public int getLimitLeft() {
        return limitLeft;
    }

    public void deleteEnemy() {
        rectangle.delete();
    }

}


