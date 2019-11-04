package game_engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BoardObserver extends KeyAdapter implements GameConstants{

        @Override
        public void keyPressed(KeyEvent ke) {
            int key = ke.getKeyCode();
            if (key == KeyEvent.VK_SPACE) {
                //TODO: implement handler functions for key presses
               // handleSpaceButton();
            }
            if (key == KeyEvent.VK_LEFT) {
                //TODO: implement handler functions for key presses
                //handleLeftArrow();
            }
            if (key == KeyEvent.VK_RIGHT) {
                //TODO: implement handler functions for key presses
                //handleLeftArrow();
                //paddle.setX(paddle.getX() + 50);
            }
        }
        @Override
        public void keyReleased(KeyEvent ke) {
            int key = ke.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                //TODO: implement handler functions for key releases
            }
            if (key == KeyEvent.VK_RIGHT) {
                //TODO: implement handler functions for key releases
                //paddle.setX(paddle.getX());
            }
        }


    }


