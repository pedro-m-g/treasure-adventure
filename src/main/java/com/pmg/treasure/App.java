package com.pmg.treasure;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class App
{

    private static final String WINDOW_TITLE = "Treasure Adventure";

    public static void main( String[] args )
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle(WINDOW_TITLE);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
