package com.pmg.treasure;

import com.pmg.treasure.configuration.Configuration;

public class App {

  private static final String CONFIGURATION_FILE_NAME = "/application.properties";

  public static void main(String[] args) {
    Configuration configuration = new Configuration(CONFIGURATION_FILE_NAME);
    GameLauncher gameBootstrap = new GameLauncher(configuration);
    gameBootstrap.start();
  }

}
