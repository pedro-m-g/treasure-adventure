package com.pmg.treasure;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame {

  private final String title;

  public MainFrame(String title) {
    this.title = title;
  }

  public void start() {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle(title);

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);

    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gamePanel.startGameThread();
  }

}
