package game;

import Entity.Gesler;
import Entity.Refugee;


import javax.swing.*;
import java.awt.*;


import static game.Game.GAME_HEIGHT;
import static game.Game.GAME_WIDTH;

public class GamePanel extends JPanel {

    public Gesler gesler = new Gesler(50, 50);
    public Refugee refugee = new Refugee(this, 300, 300);
    private long lastCheck = 0;
    private Game game;



    public GamePanel(Game game) {
        this.game = game;
        setPanelSize();
        addKeyListener(new KeyHandler(this));
        addMouseListener(new MouseHandler(this));
        this.setBackground(Color.black);
        loadAnimations();
    }


    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
    }

    private void loadAnimations() {
        game.tilesManager.loadAnimation();
        gesler.loadAnimation();
        refugee.loadAnimation();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.tilesManager.drawMap(g);
        game.tilesManager.render(g);
        gesler.update();
        gesler.render(g);
        refugee.update();
        refugee.render(g);
    }


//    private void displayFPS() {
//        frames++;
//        if (System.currentTimeMillis() - lastCheck >= 1000) {
//            lastCheck = System.currentTimeMillis();
//            System.out.println("FPS: " + frames);
//            frames = 0;
//        }
//    }


}
