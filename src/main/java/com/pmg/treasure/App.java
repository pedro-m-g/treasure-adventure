package com.pmg.treasure;

import com.pmg.treasure.configuration.Configuration;
import com.pmg.treasure.events.KeyEventHandler;
import com.pmg.treasure.ui.MainFrame;

public class App {

  private static final String CONFIGURATION_FILE_NAME = "/application.properties";

  public static void main(String[] args) {
    Configuration configuration = new Configuration(CONFIGURATION_FILE_NAME);
    KeyEventHandler keyEventHandler = new KeyEventHandler();
    MainFrame mainFrame = new MainFrame(
      configuration.getString(Configuration.APP_TITLE),
      configuration,
      keyEventHandler
    );
    mainFrame.start();
  }

}
