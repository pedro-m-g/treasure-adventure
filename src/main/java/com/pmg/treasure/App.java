package com.pmg.treasure;

public class App {

  private static final String CONFIGURATION_FILE_NAME = "/application.properties";

  public static void main(String[] args) {
    Configuration configuration = new Configuration(CONFIGURATION_FILE_NAME);
    MainFrame mainFrame = new MainFrame(configuration);
    mainFrame.start();
  }

}
