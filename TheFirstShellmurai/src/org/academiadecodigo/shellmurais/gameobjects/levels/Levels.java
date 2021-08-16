package org.academiadecodigo.shellmurais.gameobjects.levels;

import org.academiadecodigo.shellmurais.GameManager;
import org.academiadecodigo.shellmurais.gameobjects.GameObject;

public abstract class Levels {

    protected int max;
    protected GameManager gm;
    protected GameObject[] gameObjects;

    public GameObject[] getGameObjects() {
        return gameObjects;
    }

    public abstract void init();

    public abstract void deleteAllObjects();

}
