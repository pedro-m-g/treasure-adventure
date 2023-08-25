package com.pmg.treasure.ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.pmg.treasure.FPSClock;
import com.pmg.treasure.configuration.Configuration;
import com.pmg.treasure.entities.Player;
import com.pmg.treasure.events.KeyEventHandler;

public class MainFrame {

  private final Configuration configuration;
  private final KeyEventHandler keyEventHandler;

  public MainFrame(Configuration configuration, KeyEventHandler keyEventHandler) {
    this.configuration = configuration;
    this.keyEventHandler = keyEventHandler;
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

    addEntities(gamePanel);

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
        getGamePanelDimension(tileSize),
        keyEventHandler,
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

  private FPSClock createFPSClock() {
    int framesPerSecond = configuration.getInt(Configuration.APP_FRAMES_PER_SECOND);
    return new FPSClock(framesPerSecond);
  }

  private void addEntities(GamePanel gamePanel) {
    Player player = new Player(0, 0, 4, getTileSize(), keyEventHandler);
    gamePanel.addEntity(player);
  }

}
