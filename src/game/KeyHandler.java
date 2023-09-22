package game;

import utilz.Constants;
import utilz.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        if (!gamePanel.game.collisionManager.areColliding(gamePanel.gesler, gamePanel.refugee)) {
            switch (e.getExtendedKeyCode()) {
                case KeyEvent.VK_W -> {
                    gamePanel.gesler.positionY = gamePanel.gesler.positionY - 5;
                    gamePanel.gesler.direction = Direction.UP;
                    gamePanel.gesler.setMoving(true);
                    gamePanel.gesler.playerAction = Constants.PlayerConstants.WALKING_UP;
                }
                case KeyEvent.VK_S -> {
                    gamePanel.gesler.positionY = gamePanel.gesler.positionY + 5;
                    gamePanel.gesler.direction = Direction.DOWN;
                    gamePanel.gesler.setMoving(true);
                    gamePanel.gesler.playerAction = Constants.PlayerConstants.WALKING_DOWN;

                }
                case KeyEvent.VK_A -> {
                    gamePanel.gesler.positionX = gamePanel.gesler.positionX - 5;
                    gamePanel.gesler.direction = Direction.LEFT;
                    gamePanel.gesler.setMoving(true);
                    gamePanel.gesler.playerAction = Constants.PlayerConstants.WALKING_LEFT;

                }
                case KeyEvent.VK_D -> {
                    gamePanel.gesler.positionX = gamePanel.gesler.positionX + 5;
                    gamePanel.gesler.direction = Direction.RIGHT;
                    gamePanel.gesler.setMoving(true);
                    gamePanel.gesler.playerAction = Constants.PlayerConstants.WALKING_RIGHT;

                }
                case KeyEvent.VK_SPACE -> {
                    gamePanel.gesler.setAttacking(true);
                    if (gamePanel.gesler.direction.equals(Direction.UP)) {
                        gamePanel.gesler.playerAction = Constants.PlayerConstants.ATTACK_ROD_UP;
                    } else if (gamePanel.gesler.direction.equals(Direction.DOWN)) {
                        gamePanel.gesler.playerAction = Constants.PlayerConstants.ATTACK_ROD_DOWN;
                    } else if (gamePanel.gesler.direction.equals(Direction.LEFT)) {
                        gamePanel.gesler.playerAction = Constants.PlayerConstants.ATTACK_ROD_LEFT;
                    } else if (gamePanel.gesler.direction.equals(Direction.RIGHT)) {
                        gamePanel.gesler.playerAction = Constants.PlayerConstants.ATTACK_ROD_RIGHT;
                    }
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
