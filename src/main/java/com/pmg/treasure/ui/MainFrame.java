package com.pmg.treasure.ui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame {

  private final String title;
  private final GamePanel gamePanel;

  public MainFrame(String title, GamePanel gamePanel) {
    this.title = title;
    this.gamePanel = gamePanel;
  }

  public void start() {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle(title);
    window.add(gamePanel);
    window.pack();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }

}
