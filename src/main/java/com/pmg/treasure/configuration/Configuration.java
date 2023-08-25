package com.pmg.treasure.configuration;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class Configuration {

  private static final String APP_TITLE = "app.title";
  private static final String APP_FRAMES_PER_SECOND = "app.frames_per_second";

  private static final String TILES_ORIGINAL_SIZE = "tiles.original_size";
  private static final String TILES_SCALE_FACTOR = "tiles.scale_factor";

  private static final String SCREEN_COLUMNS = "screen.columns";
  private static final String SCREEN_ROWS = "screen.rows";

  private static final String PLAYER_INITIAL_POSITION_X = "player.initial_position.x";
  private static final String PLAYER_INITIAL_POSITION_Y = "player.initial_position.y";
  private static final String PLAYER_SPEED_X = "player.speed.x";
  private static final String PLAYER_SPEED_Y = "player.speed.y";

  private Properties properties;

  public Configuration(String configurationFileName) {
    properties = new Properties();
    loadConfigFromFile(configurationFileName);
  }

  public String getTitle() {
    return getString(APP_TITLE);
  }

  public int getFramesPerSecond() {
    return getInt(APP_FRAMES_PER_SECOND);
  }

  public int getTilesOriginalSize() {
    return getInt(TILES_ORIGINAL_SIZE);
  }

  public int getTilesScaleFactor() {
    return getInt(TILES_SCALE_FACTOR);
  }

  public int getTilesScaledSize() {
    return getTilesOriginalSize() * getTilesScaleFactor();
  }

  public int getScreenColumns() {
    return getInt(SCREEN_COLUMNS);
  }

  public int getScreenRows() {
    return getInt(SCREEN_ROWS);
  }

  public int getScreenWidth() {
    return getScreenColumns() * getTilesScaledSize();
  }

  public int getScreenHeight() {
    return getScreenRows() * getTilesScaledSize();
  }

  public int getPlayerInitialPositionX() {
    return getInt(PLAYER_INITIAL_POSITION_X);
  }

  public int getPlayerInitialPositionY() {
    return getInt(PLAYER_INITIAL_POSITION_Y);
  }

  public int getPlayerSpeedX() {
    return getInt(PLAYER_SPEED_X);
  }

  public int getPlayerSpeedY() {
    return getInt(PLAYER_SPEED_Y);
  }

  private void loadConfigFromFile(String configurationFileName) {
    try {
      properties.load(getClass().getResourceAsStream(configurationFileName));
    } catch (IOException ex) {
      throw new ConfigurationNotLoadedException(configurationFileName);
    }
  }

  private String getString(String key) {
    return Optional.ofNullable(properties.getProperty(key))
        .map(Object::toString)
        .orElseThrow(() -> new ConfigurationKeyNotFoundException(key));
  }

  private int getInt(String key) {
    return Optional.ofNullable(properties.getProperty(key))
        .map(Object::toString)
        .map(Integer::parseInt)
        .orElseThrow(() -> new ConfigurationKeyNotFoundException(key));
  }

}
