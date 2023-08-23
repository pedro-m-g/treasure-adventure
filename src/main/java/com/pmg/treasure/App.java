package com.pmg.treasure;

public class App {

  private static final String CONFIGURATION_FILE_NAME = "/application.properties";
  private static final Configuration CONFIGURATION = new Configuration(CONFIGURATION_FILE_NAME);

  public static void main(String[] args) {
    String title = CONFIGURATION.getString(Configuration.APP_TITLE);

    MainFrame mainFrame = new MainFrame(title);
    mainFrame.start();
  }

  public static Configuration geConfiguration() {
    return CONFIGURATION;
  }

}
