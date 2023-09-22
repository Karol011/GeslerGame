package game;

import Entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class HealthBar {

    public GamePanel gamePanel;
    private int width = 408;
    private int height = 122;
    private BufferedImage[] healthBarImage;
    public Entity entity;

    public HealthBar(Entity entity) {
        this.entity = entity;
        loadHealthBarImages();
    }

    public void render(Graphics g) {
        g.drawImage(healthBarImage[entity.healthPoints.getHealthPoints()], (this.entity.positionX + 2), (this.entity.positionY - 5), 60, 20, null);
    }

    private void loadHealthBarImages() {
        String imagePath = "/HealthBar/Health bar.png";
        healthBarImage = new BufferedImage[16];
        BufferedImage image;

        InputStream is = null;
        try {
            for (int j = 0; j < healthBarImage.length; j++) {
                is = getClass().getResourceAsStream("/HealthBar/" + "Health bar" + j + ".png");
                image = ImageIO.read(is);
                healthBarImage[j] = image.getSubimage(0, 0, width, height);
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

}
