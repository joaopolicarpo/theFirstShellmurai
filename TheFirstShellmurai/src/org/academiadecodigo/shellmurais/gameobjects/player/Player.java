package org.academiadecodigo.shellmurais.gameobjects.player;

import org.academiadecodigo.shellmurais.GameManager;
import org.academiadecodigo.shellmurais.gameobjects.GameObject;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends GameObject {

    Movements keyboard;
    private boolean isCollidedRIGHT = false;
    private boolean isCollidedLEFT = false;
    private boolean isCollidedUP = false;
    private boolean isCollidedDOWN = false;
    private GameManager gameManager;
    private boolean isOnGround = false;
    private boolean isCollided = false;
    private int initialX;
    private int initialY;

    public Player(int x, int y, String file, GameManager gameManager) {
        rectangle = new Picture(x, y, file);
        keyboard = new Movements(this, rectangle, gameManager);
        initialX = x;
        initialY = y;
        init();
        keyboard.init();
        this.gameManager = gameManager;

    }

    public boolean isCollided() {
        return isCollided;
    }

    public void setIsCollided(boolean state) {
        isCollided = state;
    }

    @Override
    protected void init() {
        rectangle.draw();

    }

    public void applyGravity() {
        if (!isOnGround) {
            try {

                Thread.sleep(25);
            } catch (Exception e) {
                System.out.println("ERRO");
            }
            this.rectangle.translate(0, 10);
        }
    }

    public void relocate() {
        int x = initialX - getXPos();
        int y = initialY - getYPos();
        rectangle.translate(x, y);

    }

    public void deletePlayer() {
        rectangle.delete();
    }

    public boolean isOnGround() {
        return isOnGround;
    }

    public void setOnGround(boolean onGround) {
        isOnGround = onGround;
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
