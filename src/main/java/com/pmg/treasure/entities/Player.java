package com.pmg.treasure.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import com.pmg.treasure.events.Key;
import com.pmg.treasure.events.KeyEventHandler;

public class Player implements Entity {

  private final KeyEventHandler keyEventHandler;

  private int x;
  private int y;
  private int speed;
  private int tileSize;

  public Player(
    int initialX,
    int initialY,
    int speed,
    int tileSize,
    KeyEventHandler keyEventHandler
  ) {
    this.x = initialX;
    this.y = initialY;
    this.speed = speed;
    this.tileSize = tileSize;
    this.keyEventHandler = keyEventHandler;
  }

  @Override
  public void update() {
    if (keyEventHandler.isKeyPressed(Key.UP)) {
      y -= speed;
    }
    if (keyEventHandler.isKeyPressed(Key.DOWN)) {
      y += speed;
    }
    if (keyEventHandler.isKeyPressed(Key.LEFT)) {
      x -= speed;
    }
    if (keyEventHandler.isKeyPressed(Key.RIGHT)) {
      x += speed;
    }
  }

  @Override
  public void render(Graphics2D g) {
    g.setColor(Color.WHITE);
    g.fillRect(x, y, tileSize, tileSize);
  }

}
