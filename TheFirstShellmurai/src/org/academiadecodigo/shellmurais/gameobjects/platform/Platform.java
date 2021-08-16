package org.academiadecodigo.shellmurais.gameobjects.platform;

import org.academiadecodigo.shellmurais.GameManager;
import org.academiadecodigo.shellmurais.gameobjects.GameObject;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Platform extends GameObject {

    protected Picture rectangle;
    private GameManager gameManager;

    public Platform(int x, int y, String file, GameManager gameManager) {
        rectangle = new Picture(x, y, file);
        this.gameManager = gameManager;
        init();

    }

    public void init() {
        rectangle.draw();

    }

    public void deletePlatforms() {
        rectangle.delete();
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
