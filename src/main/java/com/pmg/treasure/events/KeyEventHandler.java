package com.pmg.treasure.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EnumMap;
import java.util.Map;

public class KeyEventHandler implements KeyListener {

  private Map<Key, Boolean> keyMap;

  public KeyEventHandler() {
    keyMap = new EnumMap<>(Key.class);
    keyMap.put(Key.UP, false);
    keyMap.put(Key.DOWN, false);
    keyMap.put(Key.LEFT, false);
    keyMap.put(Key.RIGHT, false);
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // Do nothing
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();

    if (code == KeyEvent.VK_UP) {
      keyMap.put(Key.UP, true);
    }
    if (code == KeyEvent.VK_DOWN) {
      keyMap.put(Key.DOWN, true);
    }
    if (code == KeyEvent.VK_LEFT) {
      keyMap.put(Key.LEFT, true);
    }
    if (code == KeyEvent.VK_RIGHT) {
      keyMap.put(Key.RIGHT, true);
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();

    if (code == KeyEvent.VK_UP) {
      keyMap.put(Key.UP, false);
    }
    if (code == KeyEvent.VK_DOWN) {
      keyMap.put(Key.DOWN, false);
    }
    if (code == KeyEvent.VK_LEFT) {
      keyMap.put(Key.LEFT, false);
    }
    if (code == KeyEvent.VK_RIGHT) {
      keyMap.put(Key.RIGHT, false);
    }
  }

  public boolean isKeyPressed(Key keyPressed) {
    return keyMap.get(keyPressed);
  }

}
