package com.pmg.treasure.ui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Stage {

  private final String title;
  private final Scene scene;

  public Stage(String title, Scene scene) {
    this.title = title;
    this.scene = scene;
  }

  public void start() {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle(title);
    window.add(scene);
    window.pack();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }

  public Scene getScene() {
    return scene;
  }

}
