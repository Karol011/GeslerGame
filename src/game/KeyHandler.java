package game;

import utilz.Constants.PlayerConstants.*;
import utilz.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import static utilz.Constants.PlayerConstants.GESLER_SPEED;
//import static utilz.Constants.PlayerConstants.WALKING_UP;
import static utilz.Constants.PlayerConstants.*;


public class KeyHandler implements KeyListener {

    private GamePanel gamePanel;

    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean geslerAndRefugeeColliding = gamePanel.game.collisionManager.areColliding(gamePanel.gesler, gamePanel.refugee);

        switch (e.getExtendedKeyCode()) {
            case KeyEvent.VK_W -> {
                if (!geslerAndRefugeeColliding) {
                    gamePanel.gesler.positionY = gamePanel.gesler.positionY - GESLER_SPEED;
                    gamePanel.gesler.direction = Direction.UP;
                    gamePanel.gesler.setMoving(true);
                    gamePanel.gesler.playerAction = WALKING_UP;
                }
            }
            case KeyEvent.VK_S -> {
                if (!geslerAndRefugeeColliding) {
                    gamePanel.gesler.positionY = gamePanel.gesler.positionY + GESLER_SPEED;
                    gamePanel.gesler.direction = Direction.DOWN;
                    gamePanel.gesler.setMoving(true);
                    gamePanel.gesler.playerAction = WALKING_DOWN;
                }

            }
            case KeyEvent.VK_A -> {
                if (!geslerAndRefugeeColliding) {
                    gamePanel.gesler.positionX = gamePanel.gesler.positionX - GESLER_SPEED;
                    gamePanel.gesler.direction = Direction.LEFT;
                    gamePanel.gesler.setMoving(true);
                    gamePanel.gesler.playerAction = WALKING_LEFT;
                }
            }
            case KeyEvent.VK_D -> {
                if (!geslerAndRefugeeColliding) {
                    gamePanel.gesler.positionX = gamePanel.gesler.positionX + GESLER_SPEED;
                    gamePanel.gesler.direction = Direction.RIGHT;
                    gamePanel.gesler.setMoving(true);
                    gamePanel.gesler.playerAction = WALKING_RIGHT;
                }
            }
            case KeyEvent.VK_SPACE -> {
                gamePanel.gesler.setAttacking(true);
                if (gamePanel.gesler.direction.equals(Direction.UP)) {
                    gamePanel.gesler.playerAction = ATTACK_ROD_UP;
                } else if (gamePanel.gesler.direction.equals(Direction.DOWN)) {
                    gamePanel.gesler.playerAction = ATTACK_ROD_DOWN;
                } else if (gamePanel.gesler.direction.equals(Direction.LEFT)) {
                    gamePanel.gesler.playerAction = ATTACK_ROD_LEFT;
                } else if (gamePanel.gesler.direction.equals(Direction.RIGHT)) {
                    gamePanel.gesler.playerAction = ATTACK_ROD_RIGHT;
                }
            }
        }
    }



    @Override
    public void keyReleased(KeyEvent e) {

        gamePanel.gesler.setMoving(false);
        if (e.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
            gamePanel.gesler.setAttacking(false);
        }
        gamePanel.gesler.resetAnimation();
    }
}
