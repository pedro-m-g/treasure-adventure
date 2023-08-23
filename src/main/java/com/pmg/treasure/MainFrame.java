package com.pmg.treasure;

import java.awt.Dimension;

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
    int tileSize = getTileSize();
    return new GamePanel(
        tileSize,
        getGamePanelDimension(tileSize),
        createKeyEventHandler(),
        createFPSClock());
  }

  private int getTileSize() {
    int originalSize = configuration.getInt(Configuration.TILES_ORIGINAL_SIZE_PX);
    int scaleFactor = configuration.getInt(Configuration.TILES_SCALE_FACTOR);
    return originalSize * scaleFactor;
  }

  private Dimension getGamePanelDimension(int tileSize) {
    int columns = configuration.getInt(Configuration.SCREEN_COLUMNS);
    int rows = configuration.getInt(Configuration.SCREEN_ROWS);
    return new Dimension(columns * tileSize, rows * tileSize);
  }

  private KeyEventHandler createKeyEventHandler() {
    return new KeyEventHandler();
  }

  private FPSClock createFPSClock() {
    int framesPerSecond = configuration.getInt(Configuration.APP_FRAMES_PER_SECOND);
    return new FPSClock(framesPerSecond);
  }

}
