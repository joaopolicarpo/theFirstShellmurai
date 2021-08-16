package org.academiadecodigo.shellmurais.gameobjects.enemies;

import org.academiadecodigo.shellmurais.GameManager;
import org.academiadecodigo.shellmurais.gameobjects.levels.Level1;
import org.academiadecodigo.shellmurais.gameobjects.levels.Levels;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class NPC extends Enemy{

    private GameManager gameManager;
    private boolean questCompleted;


    public NPC(int x, int y, String file) {
        rectangle = new Picture(x, y, file);

        questCompleted = false;
        init();
    }

    @Override
    protected void init() {
        rectangle.draw();

    }

    public void setQuestCompleted(boolean qc) {
        questCompleted = qc;
    }

    public boolean getQuestCompleted() { return questCompleted; }


    @Override
    public void moveEnemyRight() /*throws Exception*/ {
        walk(0,0);

    }
    @Override
    public void moveEnemyLeft() /*throws Exception*/ {
        walk(0,0);

    }

    @Override
    protected void walk(int moveSpeed, int delay)  {

    }

    public void deleteItem(){
        rectangle.delete();
    }

}
