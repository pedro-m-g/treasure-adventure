package com.pmg.treasure.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.pmg.treasure.FPSClock;
import com.pmg.treasure.entities.Entity;
import com.pmg.treasure.events.KeyEventHandler;

public class GamePanel extends JPanel implements Runnable {

  private transient Thread gameThread;
  private final transient KeyEventHandler keyboardHandler;
  private final transient FPSClock fpsClock;

  private final transient List<Entity> entities;

  public GamePanel(
    Dimension dimension,
    KeyEventHandler keyboardHandler,
    FPSClock fpsClock
  ) {
    this.keyboardHandler = keyboardHandler;
    this.fpsClock = fpsClock;
    this.entities = new ArrayList<>();
    configurePanel(dimension);
    startGameThread();
  }

  public void add(Entity entity) {
    entities.add(entity);
  }

  private void startGameThread() {
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
    entities.stream().forEach(Entity::update);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    entities.stream().forEach(entity -> entity.render(g2));
    g2.dispose();
  }

  private void configurePanel(Dimension dimension) {
    setPreferredSize(dimension);
    setBackground(Color.BLACK);
    setDoubleBuffered(true);
    addKeyListener(keyboardHandler);
    setFocusable(true);
  }

}
