package tiles;

import game.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class TilesManager {

    public Game game;
    public BufferedImage image;
    public BufferedImage[][] cityMapTiles;

    public TilesManager(Game game) {
        this.game = game;
    }

    public void loadAnimation() {
        String imagePath = "/geslerMap.png";
        InputStream is = getClass().getResourceAsStream(imagePath);
        try {
            image = ImageIO.read(is);
            cityMapTiles = new BufferedImage[80][64];
            for (int j = 0; j < cityMapTiles.length; j++) {
                for (int i = 0; i < cityMapTiles[j].length; i++) {
                    cityMapTiles[j][i] = image.getSubimage(j * 16, i * 16, 16, 16);
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

    public void drawMap(Graphics g) {
        for (int i = 0; i < cityMapTiles.length; i++) {
            for (int j = 0; j < cityMapTiles[i].length; j++) {
                g.drawImage(cityMapTiles[i][j], i * 16, j * 16, 16, 16, null);
            }
        }
    }

    public void render(Graphics g) {

    }

    public void update() {

    }

}
