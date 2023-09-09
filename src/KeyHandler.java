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
        switch (e.getExtendedKeyCode()) {
            case KeyEvent.VK_W -> gamePanel.yDelta = gamePanel.yDelta -5;
            case KeyEvent.VK_S -> gamePanel.yDelta = gamePanel.yDelta +5;
            case KeyEvent.VK_A -> gamePanel.xDelta = gamePanel.xDelta -5;
            case KeyEvent.VK_D -> gamePanel.xDelta = gamePanel.xDelta +5;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
