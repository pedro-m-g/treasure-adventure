package com.pmg.treasure;

public class ConfigurationKeyNotFoundException extends RuntimeException {

  private final String configurationKey;

  public ConfigurationKeyNotFoundException(String configurationKey) {
    super(String.format("Configuration key not found: %s", configurationKey));
    this.configurationKey = configurationKey;
  }

  public String getConfigurationKey() {
    return configurationKey;
  }

}
