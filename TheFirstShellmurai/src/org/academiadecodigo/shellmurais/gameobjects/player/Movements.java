package org.academiadecodigo.shellmurais.gameobjects.player;

import org.academiadecodigo.shellmurais.GameManager;
import org.academiadecodigo.shellmurais.MenuStage;
import org.academiadecodigo.shellmurais.gameobjects.GameObject;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Movements implements KeyboardHandler {

    Player player;
    Picture rectangle;
    private GameManager gameManager;
    private boolean isWalk = false;
    Keyboard keyboard;
    KeyboardEvent upMovement = new KeyboardEvent();
    KeyboardEvent spaceMovement = new KeyboardEvent();
    KeyboardEvent downMovement = new KeyboardEvent();
    KeyboardEvent rightPressed = new KeyboardEvent();
    KeyboardEvent leftPressed = new KeyboardEvent();
    KeyboardEvent quitPressed = new KeyboardEvent();


    public Movements(Player player, Picture rectangle, GameManager gameManager) {
        this.player = player;
        this.rectangle = rectangle;
        this.gameManager = gameManager;
        this.keyboard = new Keyboard(this);

    }

    public void init() {

        upMovement.setKey(KeyboardEvent.KEY_UP);
        upMovement.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        spaceMovement.setKey(KeyboardEvent.KEY_SPACE);
        spaceMovement.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        downMovement.setKey(KeyboardEvent.KEY_DOWN);
        downMovement.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        quitPressed.setKey(KeyboardEvent.KEY_Q);
        quitPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        keyboard.addEventListener(upMovement);
        keyboard.addEventListener(spaceMovement);
        keyboard.addEventListener(downMovement);
        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(quitPressed);

    }

    public void removeEventListeners() {
        keyboard.removeEventListener(upMovement);
        keyboard.removeEventListener(spaceMovement);
        keyboard.removeEventListener(downMovement);
        keyboard.removeEventListener(rightPressed);
        keyboard.removeEventListener(leftPressed);
        keyboard.removeEventListener(quitPressed);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
            case KeyboardEvent.KEY_SPACE:
                if (player.getStartY() > 40) {
                    if (isWalk) {
                        rectangle.load("man-fly-RIGHT-1.png");
                        rectangle.translate(0, -80);
                        isWalk = false;
                    } else {
                        rectangle.load("man-fly-RIGHT-2.png");
                        rectangle.translate(0, -80);
                        isWalk = true;
                    }
                    player.setOnGround(false);
                    break;
                }
            case KeyboardEvent.KEY_DOWN:
                if (!player.isOnGround()) {
                    rectangle.translate(0, 1);
                }
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (player.getFinalX() < 1280) {
                    if (isWalk) {
                        rectangle.load("man-walk-RIGHT-1.png");
                        rectangle.translate(10, 0);
                        isWalk = false;
                    } else {
                        rectangle.load("man-walk-RIGHT-2.png");
                        rectangle.translate(10, 0);
                        isWalk = true;
                    }
                    break;
                }

            case KeyboardEvent.KEY_LEFT:
                if (player.getStartX() > 10) {
                    if (isWalk) {
                        rectangle.load("man-walk-LEFT-1.png");
                        rectangle.translate(-10, 0);
                        isWalk = false;
                    } else {
                        rectangle.load("man-walk-LEFT-2.png");
                        rectangle.translate(-10, 0);
                        isWalk = true;
                    }
                    break;
                }

            case KeyboardEvent.KEY_Q:
                gameManager.deleteObj();
                removeEventListeners();
                gameManager.setGameState(0);
                // Restarts
                gameManager.setGameStarted(false);
                System.out.println("Fechou");
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

}
