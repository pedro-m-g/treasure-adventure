package com.pmg.treasure;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

  public static final int ORIGINAL_TILE_SIZE = 16;
  public static final int SCALE_FACTOR = 3;
  public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE_FACTOR;
  public static final int SCREEN_COLUMNS = 16;
  public static final int SCREEN_ROWS = 12;
  public static final int SCREEN_WIDTH = SCREEN_COLUMNS * TILE_SIZE;
  public static final int SCREEN_HEIGHT = SCREEN_ROWS * TILE_SIZE;

  private Thread gameThread;

  public GamePanel() {
    setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    setBackground(Color.BLACK);
    setDoubleBuffered(true);
  }

  public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run() {
    
  }

}
