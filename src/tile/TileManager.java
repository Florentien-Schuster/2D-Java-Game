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
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[30];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        // Test map 1
        loadMap("/background/maps/map1.txt");
    }
    /* tile [0] = grass, [1] = grass ruins , [2] = riverbank, [3] = flowing water, [4] = flowing water 2, [5] = water bridge , [6] = cave, [7] = cave entrance, [8] = outline cave, [9] = peak cave
     * [10] = flower field blue , [11] = flower field blue 2, [12] = flower field red , [13] = flower field red 2, [14] = spawnpoint, [15] = riverbank topright to downleft left, [16] = riverbank topleft to topright left, [17] = riverbank topleft to downright right
     * [18] = riverbank straight right , [19] = riverbank topright to downleft right, [20] = riverbank straight down, [21] = grass ruins, [22] = spawn tree roots , [23] = spawn tree hanging flower
     * [24] = spawn tree stem, [25] = forest tree, [26] = forest tree, [27] = spawn tree crown*/

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/background/grass/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/background/grass/2D_game_grass_2.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/background/water/flowing_water/left/riverbank_straight.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/background/water/flowing_water/plain_water_2.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/background/water/flowing_water/plain_water.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/background/placeholder.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/background/placeholder.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/background/placeholder.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/background/placeholder.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/background/placeholder.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/background/grass/flower_field_blue.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/background/placeholder.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/background/grass/flower_field_red.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/background/placeholder.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/background/placeholder.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/background/water/flowing_water/left/riverbank_topright_to_downleft.png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/background/water/flowing_water/left/riverbank_topleft_to_downright.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/background/water/flowing_water/right/riverbank_topleft_to_downright.png"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/background/water/flowing_water/right/riverbank_straight.png"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/background/water/flowing_water/right/riverbank_topright_to_downleft.png"));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/background/water/flowing_water/down/riverbank_straight.png"));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/background/grass/grass_ruins_withered.png"));
            tile[21].collision = true;

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

        tileAnimationLoader(50);


        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;


            if (tileNum == 3) {
                if (tileLoadNum == 1) {
                    g2.drawImage(tile[4].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                }
                if (tileLoadNum == 2) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                }
            } else {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
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
}
