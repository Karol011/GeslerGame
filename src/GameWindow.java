import javax.swing.*;

public class GameWindow extends JFrame {

    JFrame jFrame;
    GamePanel gamePanel;

    public GameWindow(GamePanel gamePanel) {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.pack(); //make jframe big enough to contain its components (in my case just gamePanel)

    }
}
