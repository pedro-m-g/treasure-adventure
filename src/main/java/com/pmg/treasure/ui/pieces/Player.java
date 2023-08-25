package com.pmg.treasure.ui.pieces;

import java.awt.Color;
import java.awt.Graphics2D;

import com.pmg.treasure.events.Key;
import com.pmg.treasure.events.KeyEventHandler;

public class Player implements GamePiece {

  private final KeyEventHandler keyEventHandler;

  private int x;
  private int y;
  private int speedX;
  private int speedY;
  private int tileSize;

  public Player(
      int initialX,
      int initialY,
      int speedX,
      int speedY,
      int tileSize,
      KeyEventHandler keyEventHandler) {
    this.x = initialX;
    this.y = initialY;
    this.speedX = speedX;
    this.speedY = speedY;
    this.tileSize = tileSize;
    this.keyEventHandler = keyEventHandler;
  }

  @Override
  public void update() {
    if (keyEventHandler.isKeyPressed(Key.UP)) {
      y -= speedY;
    }
    if (keyEventHandler.isKeyPressed(Key.DOWN)) {
      y += speedY;
    }
    if (keyEventHandler.isKeyPressed(Key.LEFT)) {
      x -= speedX;
    }
    if (keyEventHandler.isKeyPressed(Key.RIGHT)) {
      x += speedX;
    }
  }

  @Override
  public void render(Graphics2D g) {
    g.setColor(Color.WHITE);
    g.fillRect(x, y, tileSize, tileSize);
  }

}
