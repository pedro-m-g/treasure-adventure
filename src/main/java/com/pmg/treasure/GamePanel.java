package com.pmg.treasure;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

  private final int tileSize;

  private final int screenWidth;
  private final int screenHeight;

  private transient Thread gameThread;
  private final transient KeyboardHandler keyboardHandler;
  private final transient FPSClock fpsClock;

  private int playerX = 100;
  private int playerY = 100;
  private int playerSpeed = 4;

  public GamePanel(
    int originalTileSize,
    int scaleFactor,
    int screenColumns,
    int screenRows,
    int framesPerSecond
  ) {
    this.tileSize = originalTileSize * scaleFactor;
    this.screenWidth = screenColumns * this.tileSize;
    this.screenHeight = screenRows * this.tileSize;

    keyboardHandler = new KeyboardHandler();
    fpsClock = new FPSClock(framesPerSecond);

    setPreferredSize(new Dimension(screenWidth, screenHeight));
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
    while (gameThread != null) {
      update();
      repaint();
      fpsClock.tick();
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
    g2.fillRect(playerX, playerY, tileSize, tileSize);
    g2.dispose();
  }

}
