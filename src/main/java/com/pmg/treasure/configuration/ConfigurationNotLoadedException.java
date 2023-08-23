package com.pmg.treasure.configuration;

public class ConfigurationNotLoadedException extends RuntimeException {

  private final String fileName;

  public ConfigurationNotLoadedException(String fileName) {
    super(String.format("Couldn't load configuration from file: %s", fileName));
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }

}
