package com.pmg.treasure;

import java.awt.Dimension;

import com.pmg.treasure.configuration.Configuration;
import com.pmg.treasure.entities.Player;
import com.pmg.treasure.events.KeyEventHandler;
import com.pmg.treasure.ui.GamePanel;
import com.pmg.treasure.ui.MainFrame;

public class App {

  private static final String CONFIGURATION_FILE_NAME = "/application.properties";

  public static void main(String[] args) {
    Configuration configuration = new Configuration(CONFIGURATION_FILE_NAME);

    String title = configuration.getString(Configuration.APP_TITLE);

    int screenColumns = configuration.getInt(Configuration.SCREEN_COLUMNS);
    int screenRows = configuration.getInt(Configuration.SCREEN_ROWS);
    int originalTileSize = configuration.getInt(Configuration.TILES_ORIGINAL_SIZE_PX);
    int tileScaleFactor = configuration.getInt(Configuration.TILES_SCALE_FACTOR);
    int tileSize = originalTileSize * tileScaleFactor;
    int screenWidth = screenColumns * tileSize;
    int screenHeight = screenRows * tileSize;
    Dimension dimension = new Dimension(screenWidth, screenHeight);

    KeyEventHandler keyEventHandler = new KeyEventHandler();

    int framesPerSecond = configuration.getInt(Configuration.APP_FRAMES_PER_SECOND);
    FPSClock fpsClock = new FPSClock(framesPerSecond);

    GamePanel gamePanel = new GamePanel(dimension, keyEventHandler, fpsClock);

    Player player = new Player(0, 0, 4, tileSize, keyEventHandler);
    gamePanel.add(player);

    MainFrame mainFrame = new MainFrame(title, gamePanel);
    mainFrame.start();
  }

}
