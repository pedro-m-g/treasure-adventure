package com.pmg.treasure.ui;

public class GameLoop implements Runnable {

  private final Stage stage;
  private final FPSClock fpsClock;
  private final Thread thread;

  public GameLoop(Stage stage, FPSClock fpsClock) {
    this.stage = stage;
    this.fpsClock = fpsClock;
    this.thread = new Thread(this);
  }

  public void start() {
    stage.start();
    thread.start();
  }

  @Override
  public void run() {
    Scene scene = stage.getScene();
    while (thread != null) {
      scene.update();
      scene.repaint();
      fpsClock.tick();
    }
  }

}
