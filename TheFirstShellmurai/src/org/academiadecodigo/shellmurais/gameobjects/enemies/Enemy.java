package org.academiadecodigo.shellmurais.gameobjects.enemies;

import org.academiadecodigo.shellmurais.gameobjects.GameObject;
import org.academiadecodigo.simplegraphics.graphics.Color;

public abstract class Enemy extends GameObject {

    protected String direction;
    protected int limitRight;
    protected int limitLeft;
    protected boolean isAlive = true;

    public abstract void moveEnemyRight();

    public abstract void moveEnemyLeft();


    protected abstract void walk(int moveSpeed, int delay);

    public boolean isAlive() {
        return isAlive;
    }

    public void setDead() {
        isAlive = false;
    }

    public String getDirection() {
        return direction;
    }

    public void verifyDirection() {
        if (direction.equals("Right") && rectangle.getX() == getLimitRight()) {
            direction = "Left";

        }
        if (direction.equals("Left") && rectangle.getX() == getLimitLeft()) {
            direction = "Right";

        }

    }

    public int getLimitRight() {
        return limitRight;
    }

    public int getLimitLeft() {
        return limitLeft;
    }

    public int getStartX() {
        return getXPos();
    }

    public int getFinalX() {
        return getXPos() + getWidth();
    }

    public int getStartY() {
        return getYPos();
    }

    public int getFinalY() {
        return getYPos() + getHeight();
    }

    public int getXPos() {
        return rectangle.getX();
    }

    public int getYPos() {
        return rectangle.getY();
    }

    public int getWidth() {
        return rectangle.getWidth();
    }

    public int getHeight() {
        return rectangle.getHeight();
    }

}
