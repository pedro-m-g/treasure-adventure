package com.pmg.treasure.ui;

public class FPSClock {

  private static final long MILLIS_PER_SECOND = 1_000;

  private final long renderInterval;

  public FPSClock(int framesPerSecond) {
    this.renderInterval = calculateRenderInterval(framesPerSecond);
  }

  private long calculateRenderInterval(int framesPerSecond) {
    return MILLIS_PER_SECOND / framesPerSecond;
  }

  public void tick() {
    try {
      Thread.sleep(renderInterval);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }

}
