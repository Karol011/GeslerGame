import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {

    public int xDelta = 0;
    public int yDelta = 0;


    long lastCheck = 0;

    BufferedImage geslerImage, dude_image;
    BufferedImage[][] animations;

    private int frames = 0, animationTick, animationIndex, animationSpeed = 20;


    public GamePanel() {
        setPanelSize();
        importImage();
        addKeyListener(new KeyHandler(this));
        addMouseListener(new MouseHandler(this));
        this.setBackground(Color.black);
        loadAnimations();
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/geslerSprites.png");
        try {
            geslerImage = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        InputStream is2 = getClass().getResourceAsStream("/Dude_Monster_Walk_6.png");
        try {
            dude_image = ImageIO.read(is2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is2.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 1024);
        setPreferredSize(size);
    }

    private void loadAnimations() {
        animations = new BufferedImage[2][6];
        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                if (j == 0) {
                    animations[j][i] = geslerImage.getSubimage(i * 32, 7 * 32, 32, 32);
                } else if (j == 1) {
                    animations[j][i] = dude_image.getSubimage(i * 32, 0, 32, 32);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateAnimationTick();
        g.drawImage(animations[0][animationIndex], xDelta + 0, yDelta + 0, 32, 32, null);
        g.drawImage(animations[1][animationIndex], xDelta + 50, yDelta + 50, 64, 64, null);

    }

    private void updateAnimationTick() {
        animationTick++;
        if (animationTick > animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= 6) {
                animationIndex = 0;
            }
        }
    }


    private void displayFPS() {
        frames++;
        if (System.currentTimeMillis() - lastCheck >= 1000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }
    }

}
