package org.academiadecodigo.shellmurais;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

    public class MenuStage implements KeyboardHandler, Runnable {

        private Sound soundMenu;
        private Picture back;
        private Picture helpBackground;
        private Text text;
        private double x;
        private double y;
        private String[] options = {"Start", "Help", "Quit"};
        private int currentSelection;
        private Text[] startT = new Text[3];
        private boolean helpMenuOpen = false;
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent upPressed = new KeyboardEvent();
        KeyboardEvent downPressed = new KeyboardEvent();
        KeyboardEvent spacePressed = new KeyboardEvent();
        KeyboardEvent escPressed = new KeyboardEvent();
        GameManager gameManager;


        public MenuStage(GameManager gm) {

            x = 640;
            y = 150;
            currentSelection = 0;
            gameManager = gm;
            back = new Picture(10, 10, "game-menu.png");
            helpBackground = new Picture(10, 10 , "help-screen.png");
            soundMenu = new Sound("/game.wav");

        }

        public void draw() {
            soundMenu.play(true);
            drawButtons();
            keyboardInit();
        }
        private void drawButtons(){
            back.draw();
            String start;
            double localY = y + 150;

            for (int i = 0; i < options.length; i++) {
                if (i == currentSelection) {

                    start = options[i];
                    startT[i] = new Text(x, localY, start);
                    startT[i].setColor(Color.RED);
                    startT[i].grow(60, 60);
                    startT[i].draw();
                    localY += 150;

                } else {

                    start = options[i];
                    startT[i] = new Text(x, localY, start);
                    startT[i].setColor(Color.WHITE);
                    startT[i].grow(60, 60);
                    startT[i].draw();
                    localY += 150;

                }
            }
        }
        private void keyboardInit() {

            upPressed.setKey(KeyboardEvent.KEY_UP);
            upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            downPressed.setKey(KeyboardEvent.KEY_DOWN);
            downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            spacePressed.setKey(KeyboardEvent.KEY_SPACE);
            spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            escPressed.setKey(KeyboardEvent.KEY_Q);
            escPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            keyboard.addEventListener(upPressed);
            keyboard.addEventListener(downPressed);
            keyboard.addEventListener(spacePressed);
            keyboard.addEventListener(escPressed);

        }

        private void removeListeners(){

            keyboard.removeEventListener(upPressed);
            keyboard.removeEventListener(downPressed);
            keyboard.removeEventListener(spacePressed);
            keyboard.removeEventListener(escPressed);

        }


        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            switch (keyboardEvent.getKey()) {

                case KeyboardEvent.KEY_UP:
                    startT[currentSelection].setColor(Color.WHITE);
                    System.out.println("up");

                    currentSelection--;
                    if (currentSelection < 0) {
                        currentSelection = options.length - 1;
                        startT[currentSelection].setColor(Color.RED);
                        break;
                    }
                    startT[currentSelection].setColor(Color.RED);
                    break;

                case KeyboardEvent.KEY_DOWN:
                    startT[currentSelection].setColor(Color.WHITE);

                    currentSelection++;
                    if (currentSelection >= options.length) {
                        currentSelection = 0;
                        startT[currentSelection].setColor(Color.RED);
                        break;
                    }
                    startT[currentSelection].setColor(Color.RED);
                    break;

                case KeyboardEvent.KEY_SPACE:
                    System.out.println("space" + currentSelection);
                    if (currentSelection == 0) {

                        removeListeners();
                        deleteAll();

                        gameManager.setGameState(1);

                    }
                    else if (currentSelection == 1) {
                        //Help
                        if (!helpMenuOpen) {
                            deleteAll();
                            back.delete();
                            helpBackground.draw();
                            helpMenuOpen = true;
                            currentSelection = 4;

                        }
                       //Exit
                    } else if (currentSelection == 2) {

                        System.exit(0);

                    } else if (helpMenuOpen) {

                        helpBackground.delete();
                        this.drawButtons();
                        helpMenuOpen = false;

                        currentSelection = 0;
                    }
                    break;
            }
        }

        public void deleteAll(){
            for (int i = 0; i < options.length ; i++) {
                startT[i].delete();
            }
            back.delete();
            helpBackground.delete();

        }


        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
        }

        @Override
        public void run() {

        }
    }
