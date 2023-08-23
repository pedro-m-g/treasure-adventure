package com.pmg.treasure;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame {

  private final Configuration configuration;

  public MainFrame(Configuration configuration) {
    this.configuration = configuration;
  }

  public void start() {
    String title = configuration.getString(Configuration.APP_TITLE);

    JFrame window = buildMainWindow();
    window.setTitle(title);

    GamePanel gamePanel = buildGamePanel();

    window.add(gamePanel);
    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gamePanel.startGameThread();
  }

  private JFrame buildMainWindow() {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setResizable(false);

    return window;
  }

  private GamePanel buildGamePanel() {
    return new GamePanel(
      configuration.getInt(Configuration.TILES_ORIGINAL_SIZE_PX),
      configuration.getInt(Configuration.TILES_SCALE_FACTOR),
      configuration.getInt(Configuration.SCREEN_COLUMNS),
      configuration.getInt(Configuration.SCREEN_ROWS),
      configuration.getInt(Configuration.APP_FRAMES_PER_SECOND)
    );
  }

}
