package game;

import tiles.TilesManager;

import java.awt.*;

public class Game implements Runnable {

    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 0.5f;
    public final static int TILES_IN_WIDTH = 80;
    public final static int TILES_IN_HEIGHT = 64;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

    private final int FPS_SET = 120;
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    public TilesManager tilesManager;


    public Game() {
        initClasses();
        gamePanel.requestFocusInWindow();
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void initClasses() {
        tilesManager = new TilesManager(this);
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
    }

    @Override
    public void run() {
        System.out.println("thread start");
        double timePerFrame = 1000000000 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        while (true) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                gamePanel.repaint();
                lastFrame = now;
            }
        }

    }
}
