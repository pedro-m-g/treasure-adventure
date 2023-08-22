package com.pmg.treasure;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class App
{
    public static void main( String[] args )
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Treasure Adventure");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
