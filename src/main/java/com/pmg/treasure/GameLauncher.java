package com.pmg.treasure;

import java.awt.Dimension;

import com.pmg.treasure.configuration.Configuration;
import com.pmg.treasure.events.KeyEventHandler;
import com.pmg.treasure.ui.FPSClock;
import com.pmg.treasure.ui.GameLoop;
import com.pmg.treasure.ui.Scene;
import com.pmg.treasure.ui.Stage;
import com.pmg.treasure.ui.pieces.Player;

public class GameLauncher {

  private final Configuration configuration;

  public GameLauncher(Configuration configuration) {
    this.configuration = configuration;
  }

  public void start() {
    String title = configuration.getTitle();
    Scene scene = createScene();
    Stage stage = new Stage(title, scene);
    FPSClock fpsClock = new FPSClock(configuration.getFramesPerSecond());
    GameLoop gameLoop = new GameLoop(stage, fpsClock);
    gameLoop.start();
  }

  private Scene createScene() {
    Dimension dimension = new Dimension(
      configuration.getScreenWidth(),
      configuration.getScreenHeight()
    );
    KeyEventHandler keyEventHandler = new KeyEventHandler();
    Scene scene = new Scene(dimension, keyEventHandler);

    Player player = new Player(
      configuration.getPlayerInitialPositionX(),
      configuration.getPlayerInitialPositionY(),
      configuration.getPlayerSpeedX(),
      configuration.getPlayerSpeedY(),
      configuration.getTilesScaledSize(),
      keyEventHandler
    );
    scene.add(player);

    return scene;
  }

}
