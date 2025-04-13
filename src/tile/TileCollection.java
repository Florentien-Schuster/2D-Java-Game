package tile;

import javax.imageio.ImageIO;
import java.io.IOException;

public class TileCollection {
    public static void waterTiles(){
        try {
            TileManager.tile[2] = new Tile();
            TileManager.tile[2].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/left/riverbank_straight.png"));
            TileManager.tile[2].collision = true;

            TileManager.tile[3] = new Tile();
            TileManager.tile[3].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/plain_water_2.png"));
            TileManager.tile[3].collision = true;

            TileManager.tile[4] = new Tile();
            TileManager.tile[4].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/plain_water.png"));
            TileManager.tile[4].collision = true;

            TileManager.tile[15] = new Tile();
            TileManager.tile[15].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/left/riverbank_topright_to_downleft.png"));
            TileManager.tile[15].collision = true;

            TileManager.tile[16] = new Tile();
            TileManager.tile[16].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/left/riverbank_topleft_to_downright.png"));
            TileManager.tile[16].collision = true;

            TileManager.tile[17] = new Tile();
            TileManager.tile[17].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/right/riverbank_topleft_to_downright.png"));
            TileManager.tile[17].collision = true;

            TileManager.tile[18] = new Tile();
            TileManager.tile[18].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/right/riverbank_straight.png"));
            TileManager.tile[18].collision = true;

            TileManager.tile[19] = new Tile();
            TileManager.tile[19].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/right/riverbank_topright_to_downleft.png"));
            TileManager.tile[19].collision = true;

            TileManager.tile[20] = new Tile();
            TileManager.tile[20].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/down/riverbank_straight.png"));
            TileManager.tile[20].collision = true;

            TileManager.tile[22] = new Tile();
            TileManager.tile[22].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/down/riverbank_straight2.png"));
            TileManager.tile[22].collision = true;

            TileManager.tile[23] = new Tile();
            TileManager.tile[23].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/left/riverbank_straight2.png"));
            TileManager.tile[23].collision = true;

            TileManager.tile[24] = new Tile();
            TileManager.tile[24].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/left/riverbank_topleft_to_downright2.png"));
            TileManager.tile[24].collision = true;

            TileManager.tile[25] = new Tile();
            TileManager.tile[25].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/left/riverbank_topright_to_downleft2.png"));
            TileManager.tile[25].collision = true;

            TileManager.tile[26] = new Tile();
            TileManager.tile[26].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/left/riverbank_straight.png"));
            TileManager.tile[26].collision = true;
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void grassTiles(){
        try{
            TileManager.tile[0] = new Tile();
            TileManager.tile[0].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/grass/grass.png"));

            TileManager.tile[1] = new Tile();
            TileManager.tile[1].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/grass/2D_game_grass_2.png"));

            TileManager.tile[10] = new Tile();
            TileManager.tile[10].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/grass/flower_field_blue.png"));

            TileManager.tile[13] = new Tile();
            TileManager.tile[13].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/grass/grass_connection_tr_dl.png"));

            TileManager.tile[14] = new Tile();
            TileManager.tile[14].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/grass/grass_connection_tl_dr.png"));

            TileManager.tile[12] = new Tile();
            TileManager.tile[12].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/grass/flower_field_red.png"));

            TileManager.tile[21] = new Tile();
            TileManager.tile[21].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/grass/grass_ruins_withered.png"));
            TileManager.tile[21].collision = true;

            TileManager.tile[27] = new Tile();
            TileManager.tile[27].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/grass/grass_connection_rightside_tr_dl.png"));

            TileManager.tile[28] = new Tile();
            TileManager.tile[28].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/grass/grass_connection_rightside_tl_dr.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void woodBridgeTiles(){
        try{
            TileManager.tile[5] = new Tile();
            TileManager.tile[5].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/wood_bridge.png"));

            TileManager.tile[6] = new Tile();
            TileManager.tile[6].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/wood_bridge_bottom.png"));

            TileManager.tile[7] = new Tile();
            TileManager.tile[7].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/wood_bottom_bridge_left.png"));

            TileManager.tile[8] = new Tile();
            TileManager.tile[8].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/wood_bridge_end_left.png"));

            TileManager.tile[9] = new Tile();
            TileManager.tile[9].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/wood_bottom_bridge_right.png"));

            TileManager.tile[11] = new Tile();
            TileManager.tile[11].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/water/flowing_water/wood_bridge_end_right.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void caveTiles(){
        try{
            TileManager.tile[29] = new Tile();
            TileManager.tile[29].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/cave/cave_entrance.png"));

            TileManager.tile[30] = new Tile();
            TileManager.tile[30].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/cave/cave_wall.png"));
            TileManager.tile[30].collision = true;

            TileManager.tile[31] = new Tile();
            TileManager.tile[31].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/cave/cave_left_side.png"));
            TileManager.tile[31].collision = true;

            TileManager.tile[32] = new Tile();
            TileManager.tile[32].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/cave/cave_left_side2.png"));

            TileManager.tile[33] = new Tile();
            TileManager.tile[33].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/cave/cave_right_side2.png"));

            TileManager.tile[34] = new Tile();
            TileManager.tile[34].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/cave/cave_right_side.png"));
            TileManager.tile[34].collision = true;

            TileManager.tile[35] = new Tile();
            TileManager.tile[35].image = ImageIO.read(TileCollection.class.getResourceAsStream("/background/cave/cave_peak.png"));
            TileManager.tile[35].collision = true;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
