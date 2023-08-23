package com.pmg.treasure;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class Configuration {

  public static final String APP_TITLE = "app.title";
  public static final String APP_FRAMES_PER_SECOND = "app.frames_per_second";
  public static final String TILES_ORIGINAL_SIZE_PX = "tiles.original_size_px";
  public static final String TILES_SCALE_FACTOR = "tiles.scale_factor";
  public static final String TILES_SCALED_SIZE_PX = "tiles.scaled_size_px";
  public static final String SCREEN_COLUMNS = "screen.columns";
  public static final String SCREEN_ROWS = "screen.rows";
  public static final String SCREEN_WIDTH_PX = "screen.width_px";
  public static final String SCREEN_HEIGHT_PX = "screen.height_px";

  private Properties properties;

  public Configuration(String configurationFileName) {
    properties = new Properties();
    loadConfigFromFile(configurationFileName);
  }

  private void loadConfigFromFile(String configurationFileName) {
    try {
      properties.load(getClass().getResourceAsStream(configurationFileName));
    } catch (IOException ex) {
      throw new ConfigurationNotLoadedException(configurationFileName);
    }
  }

  public String getConfig(String key) {
    return Optional.ofNullable(properties.getProperty(key))
            .map(Object::toString)
            .orElseThrow(() -> new ConfigurationKeyNotFoundException(key));
  }

  public int getConfigAsInt(String key) {
    return Optional.ofNullable(properties.getProperty(key))
            .map(Object::toString)
            .map(Integer::parseInt)
            .orElseThrow(() -> new ConfigurationKeyNotFoundException(key));
  }

}
