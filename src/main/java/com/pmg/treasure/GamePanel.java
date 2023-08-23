package com.pmg.treasure;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

  private static final int ORIGINAL_TILE_SIZE = 16;
  private static final int SCALE_FACTOR = 3;
  private static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE_FACTOR;
  private static final int SCREEN_COLUMNS = 16;
  private static final int SCREEN_ROWS = 12;
  private static final int SCREEN_WIDTH = SCREEN_COLUMNS * TILE_SIZE;
  private static final int SCREEN_HEIGHT = SCREEN_ROWS * TILE_SIZE;
  private static final int NANOSECONDS_PER_SECOND = 1_000_000_000;
  private static final int NANOSECONDS_PER_MILLISECOND = 1_000_000;
  private static final int FRAMES_PER_SECOND = 60;
  private static final double DRAW_INTERVAL = NANOSECONDS_PER_SECOND / FRAMES_PER_SECOND;

  private transient Thread gameThread;
  private transient KeyboardHandler keyboardHandler = new KeyboardHandler();

  private int playerX = 100;
  private int playerY = 100;
  private int playerSpeed = 4;

  public GamePanel() {
    setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    setBackground(Color.BLACK);
    setDoubleBuffered(true);
    addKeyListener(keyboardHandler);
    setFocusable(true);
  }

  public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run() {
    double nextDrawTime = System.nanoTime() + DRAW_INTERVAL;

    while (gameThread != null) {
      update();
      repaint();

      try {
        double remainingTimeNanos = nextDrawTime - System.nanoTime();
        long remainingTimeMillis = (long) (remainingTimeNanos / NANOSECONDS_PER_MILLISECOND);
        if (remainingTimeMillis < 0) {
          remainingTimeMillis = 0;
        }
        Thread.sleep(remainingTimeMillis);
        nextDrawTime += DRAW_INTERVAL;
      } catch (InterruptedException ex) {
        ex.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
  }

  public void update() {
    if (keyboardHandler.isUpPressed()) {
      playerY -= playerSpeed;
    }
    if (keyboardHandler.isDownPressed()) {
      playerY += playerSpeed;
    }
    if (keyboardHandler.isLeftPressed()) {
      playerX -= playerSpeed;
    }
    if (keyboardHandler.isRightPressed()) {
      playerX += playerSpeed;
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.WHITE);
    g2.fillRect(playerX, playerY, TILE_SIZE, TILE_SIZE);
    g2.dispose();
  }

}
