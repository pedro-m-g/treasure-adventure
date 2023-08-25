package com.pmg.treasure;

import java.awt.Dimension;

import com.pmg.treasure.configuration.Configuration;
import com.pmg.treasure.events.KeyEventHandler;
import com.pmg.treasure.ui.Scene;
import com.pmg.treasure.ui.Stage;
import com.pmg.treasure.ui.pieces.Player;

public class App {

  private static final String CONFIGURATION_FILE_NAME = "/application.properties";

  public static void main(String[] args) {
    Configuration configuration = new Configuration(CONFIGURATION_FILE_NAME);

    String title = configuration.getTitle();
    Dimension dimension = new Dimension(
      configuration.getScreenWidth(),
      configuration.getScreenHeight()
    );
    KeyEventHandler keyEventHandler = new KeyEventHandler();
    FPSClock fpsClock = new FPSClock(configuration.getFramesPerSecond());

    Scene scene = new Scene(dimension, keyEventHandler, fpsClock);

    Player player = new Player(
      configuration.getPlayerInitialPositionX(),
      configuration.getPlayerInitialPositionY(),
      configuration.getPlayerSpeedX(),
      configuration.getPlayerSpeedY(),
      configuration.getTilesScaledSize(),
      keyEventHandler
    );
    scene.add(player);

    Stage stage = new Stage(title, scene);
    stage.start();
  }

}
