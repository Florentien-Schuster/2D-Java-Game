package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


public class TileManager {
    GamePanel gp;
    public static int tileLoadNum = 1;
    public static int tileCounter = 0;
    public static Tile[] tile;
    public int[][] mapTileNum;
    int tileNum;
    int screenX;
    int screenY;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        // Test map 1
        loadMap("/background/maps/map1.txt");
    }

    public void getTileImage() {
        try {
            TileCollection.waterTiles();
            TileCollection.grassTiles();
            TileCollection.woodBridgeTiles();
            TileCollection.caveTiles();

            tile[38] = new Tile(); // 36
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/test_1.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String mapPath) {
        try {
            InputStream is = getClass().getResourceAsStream(mapPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;


            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine().trim();

                while (col < gp.maxWorldCol) {
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    //System.out.println(Arrays.toString(new int[]{mapTileNum[col][row]}));
                    //System.out.println(col);
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        tileAnimationLoader(40);


        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            screenX = worldX - gp.player.worldX + gp.player.screenX;
            screenY = worldY - gp.player.worldY + gp.player.screenY;

            animations(g2);

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;

                worldRow++;

            }
        }
    }

    public static void tileAnimationLoader(int counter) {
        tileCounter++;
        if (tileCounter > counter) {
            if (tileLoadNum == 1) {
                tileLoadNum = 2;
            } else if (tileLoadNum == 2) {
                tileLoadNum = 1;
            }
            tileCounter = 0;


        }
    }
    //TODO: Improve tile organisation
    public void animations(Graphics2D g2){
        if (tileNum == 3) {
            switch(tileLoadNum){
                case 1:
                    g2.drawImage(tile[4].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                    break;
                case 2:
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                    break;
            }
        }else if(tileNum == 20) {
            switch(tileLoadNum){
                case 1:
                    g2.drawImage(tile[22].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                    break;
                case 2:
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                    break;
            }
        }else if(tileNum == 2) {
            switch (tileLoadNum){
                case 1:
                    g2.drawImage(tile[23].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                    break;
                case 2:
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                    break;
            }
        }else if(tileNum == 15) {
            switch(tileLoadNum){
                case 1:
                    g2.drawImage(tile[25].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                    break;
                case 2:
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                    break;
            }
        }else if(tileNum == 16) {
            switch(tileLoadNum){
                case 1:
                    g2.drawImage(tile[24].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                    break;
                case 2:
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                    break;
            }
            // TODO: implement rightside river animations
        // }else if(tileNum == 17){

        } else {
            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
    public void riverAnimations(Graphics2D g2){

    }
}
