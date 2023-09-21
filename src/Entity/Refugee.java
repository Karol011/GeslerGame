package Entity;

import game.GamePanel;
import utilz.Constants;
import utilz.Direction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static utilz.Constants.PlayerConstants.*;

public class Refugee extends Entity {

    private int width = 64;
    private int height = 64;
    private BufferedImage refugeeImage;
    private BufferedImage[][] animations;
    public boolean moving = true;
    public boolean attacking = false;
    Random random = new Random();
    public GamePanel gamePanel;


    public Enum<Direction> direction = Direction.DOWN;
    private int movingInterval = 1200, tick, animationIndex, animationSpeed = 10;
    public int refugeeAction = WALKING_DOWN;


    public Refugee(GamePanel gamePanel, int positionX, int positionY) {
        super(positionX, positionY);
        this.gamePanel = gamePanel;
    }


    public void update() {
        setAnimation();
    }


    public void render(Graphics g) {
        g.drawImage(animations[refugeeAction][animationIndex], super.positionX, super.positionY, this.width, this.height, null);
    }

    private void setAnimation() {
        if (moving) {
            updateAnimationTick();
            moveRandomly();
        } else if (attacking) {
            updateAnimationTick();
        }
    }

    private void updateAnimationTick() {
        tick++;
        if (tick > animationSpeed) {
            tick = 0;
            animationIndex++;
            if (animationIndex >= GetSpritesAmount(refugeeAction)) {
                animationIndex = 0;
                // moveRandomly();
            }
        }
    }

    public void moveRandomly() {
        int randomValue = random.nextInt(50) + 1;
        for (int i = 0; i < randomValue; i++) {
            switch (determineRandomDirection()) {
                case UP -> {
                    this.positionY = this.positionY - 1;
                    gamePanel.refugee.refugeeAction = WALKING_UP;
                }
                case DOWN -> {
                    this.positionY = this.positionY + 1;
                    gamePanel.refugee.refugeeAction = WALKING_DOWN;
                }
                case LEFT -> {
                    this.positionX = this.positionX - 1;
                    gamePanel.refugee.refugeeAction = WALKING_LEFT;
                }
                case RIGHT -> {
                    this.positionX = this.positionX + 1;
                    gamePanel.refugee.refugeeAction = WALKING_RIGHT;
                }
            }
        }

    }


    private Direction determineRandomDirection() {
        Direction direction;
        int randomValue = random.nextInt(100) + 1;
        if (randomValue <= 25) {
            direction = Direction.UP;
        } else if (randomValue <= 50) {
            direction = Direction.LEFT;
        } else if (randomValue <= 75) {
            direction = Direction.RIGHT;
        } else {
            direction = Direction.DOWN;
        }
        return direction;
    }


    public void resetAnimation() {
        animationIndex = 0;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void loadAnimation() {
        String refugeePath = "/refugee.png";
        InputStream is = getClass().getResourceAsStream(refugeePath);
        try {
            refugeeImage = ImageIO.read(is);
            animations = new BufferedImage[21][13];
            for (int j = 0; j < animations.length; j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = refugeeImage.getSubimage(i * this.width, j * this.height, 64, 64);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }


}