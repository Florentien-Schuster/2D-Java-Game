package main;

import main.GamePanel;

import javax.swing.*;

// TODO: improve rendering to reduce lag
// Idee: Lade nur die Tiles in einem best. Umkreis um den Spieler herum (beachte Bildgröße zwecks Rand)

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        // TODO: set gamename & windowname accordingly
        window.setTitle("2D Game - Placeholder");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();

    }
}