package Entity;

import utilz.Direction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.*;

public class Gesler extends Entity {
    private int width = 64;
    private int height = 64;
    private BufferedImage geslerImage;
    private BufferedImage[][] animations;
    private BufferedImage[][] attackAnimations;
    public boolean moving = false;
    public boolean attacking = false;

    public Enum<Direction> direction = Direction.DOWN;
    private int frames = 0, animationTick, animationIndex, animationSpeed = 10;
    public int playerAction = WALKING_DOWN;

    public Gesler(int positionX, int positionY) {
        super(positionX, positionY);
        loadAnimation();
    }

    public void update() {
        setAnimation();
    }


    public void render(Graphics g) {
        g.drawImage(animations[playerAction][animationIndex], super.positionX + 111, super.positionY + 130, this.width, this.height, null);
    }

    private void setAnimation() {
        if (moving) {
            updateAnimationTick();
        } else if (attacking) {
            updateAnimationTick();
        }
    }

    private void updateAnimationTick() {
        animationTick++;
        if (animationTick > animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= GetSpritesAmount(playerAction)) {
                animationIndex = 0;
            }
        }
    }

    public void resetAnimation() {
        animationIndex = 0;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void loadAnimation() {
        String geslerPath = "/gesler.png";
        InputStream is = getClass().getResourceAsStream(geslerPath);
        try {
            geslerImage = ImageIO.read(is);
            animations = new BufferedImage[25][13];
            for (int j = 0; j < animations.length; j++) {
                int yValueAfter21Row = ((21 * 64) + ((j - 21) * 128)); //After 21 row size of the subimage changes from 64x64 to 128x128, so it needs to change accordingly
                for (int i = 0; i < animations[j].length; i++) {
                    if (j < 21) {
                        animations[j][i] = geslerImage.getSubimage(i * this.width, j * this.height, 64, 64);
                    } else if (j >= 21) {
                        animations[j][i] = geslerImage.getSubimage((i * 128), yValueAfter21Row, 128, 128);
                    }
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
