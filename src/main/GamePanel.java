package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // Screen settings
    final int originalTileSize = 16; // 16x16 default size of npc/map tiles etc.
    final int scale = 3; // scale up for tile size
    public int tileSize = originalTileSize * scale; // 1 tile = 16x3 = 48 px on screen
    public final int maxScreenCol = 16; // 16 tiles horizontal
    public final int maxScreenRow = 12; // 12 tiles vertical, together ratio 4:3
    public final int screenWidth = tileSize * maxScreenCol; // 768 px
    public final int screenHeight = tileSize * maxScreenRow; // 576 px

    // FPS
    int fps = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread; // game loop
    Player player = new Player(this,keyH);
    TileManager tileTest = new TileManager(this);


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // improves game rendering
        this.addKeyListener(keyH); // looks for key inputs
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/fps; // draws screen ~0.016 sec (60 times per second)
        double nextDrawTime = System.nanoTime() + drawInterval;

        // game loop
        while(gameThread != null){
            // long currentTime = System.nanoTime();

            // update information
            update();

            // draw screen
            repaint(); // calls paintComponent();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void update(){

        player.update();

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileTest.draw(g2);
        player.draw(g2);

        g2.dispose(); // saves memory

    }
}
