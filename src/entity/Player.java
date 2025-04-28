package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

// TODO: implement sprites/animations for diagonal movement,up,down & dodge roll

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    int normalSpeed = 5;
    int rollingSpeed = 15;
    int speed = normalSpeed;
    boolean isRolling = false;
    int rollDuration = 20;
    int rollCounter = 0;
    int spriteWidth = 32;
    int spriteHeight = 32;
    static int spriteNumRunning = 0;
    static int spriteNumRolling = 0;
    static int spriteNumIdle = 0;
    /*int spriteY = 0;
    int spriteX = 0;
    BufferedImage[][] sprites;
    BufferedImage running_right;
    int frame = 0;*/

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle(8,64,32,32);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = gp.tileSize * 23; // 8
        worldY = gp.tileSize * 23; // 6
        //speed = normalSpeed;
        diagonalSpeed = (float) (speed/Math.sqrt(2));
        direction = "down";
    }

    public void getPlayerImage(){
            ocRunningLeft = spriteSheetLoader("/Test/blanc_char_running_left.png");
            ocRunningRight = spriteSheetLoader("/Test/blanc_char_running_right.png");
            ocIdleDown = spriteSheetLoader("/Test/blanc_char_drinking_idle_down.png");
            ocDodgeRollRight = spriteSheetLoader("/Test/test_roll.png");
            ocDodgeRollLeft = spriteSheetLoader("/Test/test_roll_left.png");
            ocIdleLeft = spriteSheetLoader("/Test/idle_left.png");
            ocIdleRight = spriteSheetLoader("/Test/idle_right.png");
    }
    public BufferedImage[] spriteSheetLoader(String path){
        try{
            BufferedImage spriteSheet = ImageIO.read(getClass().getResourceAsStream(path));

            int spriteSheetColumns = spriteSheet.getWidth() / spriteWidth;

            BufferedImage[] sprites = new BufferedImage[spriteSheetColumns];
            for (int i = 0; i < spriteSheetColumns; i++) {
                sprites[i] = spriteSheet.getSubimage(i * spriteWidth, 0, spriteWidth, spriteHeight);
            }
            /*BufferedImage spriteSheet = ImageIO.read(getClass().getResourceAsStream((path)));

            int spriteSheetColumns = spriteSheet.getWidth() / spriteWidth;
            int spriteSheetRows = spriteSheet.getHeight() / spriteHeight;

            sprites = new BufferedImage[spriteSheetRows][spriteSheetColumns];
            for (; spriteY < spriteSheetRows ;spriteY++){
                for(; spriteX < spriteSheetColumns; spriteX++){
                    sprites[spriteY][spriteX] = spriteSheet.getSubimage(spriteX*spriteWidth,spriteY*spriteHeight,spriteWidth,spriteHeight);
                }
            }*/
            return sprites;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void update() {
        // use dodge roll with shift + direction key(wsad)
        if (keyH.dodgeRollPressed && !isRolling) {
            dodgeRollStart();
            keyH.dodgeRollPressed = false;
        }
        if (isRolling) {
            //System.out.println(rollCounter);
            rollCounter--;
            if (rollCounter <= 0) {
                dodgeRollEnd();
            }
        }

        if (keyH.upPressed|| keyH.downPressed|| keyH.leftPressed|| keyH.rightPressed) {
            if (keyH.upPressed & keyH.rightPressed) {
                direction = "up_right";
            } else if (keyH.upPressed & keyH.leftPressed) {
                direction = "up_left";
            } else if (keyH.downPressed & keyH.rightPressed) {
                direction = "down_right";
            } else if (keyH.downPressed & keyH.leftPressed) {
                direction = "down_left";
            } else if (keyH.upPressed) {
                direction = "up";
            } else if (keyH.downPressed) {
                direction = "down";
            } else if (keyH.leftPressed) {
                direction = "left";
            } else if (keyH.rightPressed) {
                direction = "right";
            }
            collisionOn = false;
            gp.checker.checkTile(this);

            if (!collisionOn) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                    case "up_right":
                        worldY -= diagonalSpeed;
                        worldX += diagonalSpeed;
                        break;
                    case "up_left":
                        worldY -= diagonalSpeed;
                        worldX -= diagonalSpeed;
                        break;
                    case "down_right":
                        worldY += diagonalSpeed;
                        worldX += diagonalSpeed;
                        break;
                    case "down_left":
                        worldY += diagonalSpeed;
                        worldX -= diagonalSpeed;
                        break;
                }
            }
            if (isRolling) {
                animationLoader(3, ocDodgeRollRight.length,"rolling");
            }else if((keyH.upPressed|| keyH.downPressed|| keyH.leftPressed|| keyH.rightPressed) && !isRolling) {
                animationLoader(8, ocRunningRight.length, "running");
            }
        }

        if (!keyH.upPressed && !keyH.downPressed&& !keyH.leftPressed&& !keyH.rightPressed){
            animationLoader(20, ocIdleLeft.length, "idle");
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;
        if(keyH.upPressed|| keyH.downPressed|| keyH.leftPressed|| keyH.rightPressed){
            switch(direction) {
                case "up":
                    if (isRolling) {
                        //image = sheet for dodgeRoll up;
                    }else{
                        image = ocIdleDown[spriteNumIdle];
                        // image = sheet for normal running up;
                    }
                    break;
                case "down":
                    if (isRolling) {
                        //image = sheet for dodgeRoll down;
                    }else{
                        // image = sheet for normal running down;
                    }
                    break;
                case "left":
                    if(isRolling){
                        image = ocDodgeRollLeft[spriteNumRolling];
                    }else {
                        image = ocRunningLeft[spriteNumRunning];
                    }
                    break;
                case "right":
                    if(isRolling || keyH.dodgeRollPressed){
                        image = ocDodgeRollRight[spriteNumRolling];
                        if(!isRolling){
                            spriteNum = 0;
                        }
                    }else {
                        image = ocRunningRight[spriteNumRunning];
                    }
            }
        }else {
            //Idle
            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = idle_up1;
                    }
                    if (spriteNum == 2) {
                        image = idle_up2;
                    }
                    break;
                case "down":
                    image = ocIdleDown[spriteNumIdle];
                    break;
                case "left":
                    image = ocIdleLeft[spriteNumIdle];
                    break;
                case "right":
                    image = ocIdleRight[spriteNumIdle];
            }
        }
        g2.drawImage(image, screenX ,screenY ,gp.tileSize,gp.tileSize,null);
    }
    public static void animationLoader(int counter, int maxFrames,String type) {
        spriteCounter++;
        if (spriteCounter > counter) {
            switch(type) {
                case "rolling":
                    spriteNumRolling++;
                    if (spriteNumRolling >= maxFrames) spriteNumRolling = 0;
                    break;
                case "running":
                    spriteNumRunning++;
                    if (spriteNumRunning >= maxFrames) spriteNumRunning = 0;
                    break;
                case"idle":
                    spriteNumIdle++;
                    if (spriteNumIdle >= maxFrames) spriteNumIdle = 0;
                    break;
                default:
                    System.out.println("No Animation loading!");
            }
            /*spriteNum++;
            if(spriteNum >= maxFrames){
                spriteNum = 0;
            }*/
            spriteCounter = 0;
           }
    }
    public void dodgeRollStart(){
        isRolling = true;
        speed = rollingSpeed;
        diagonalSpeed = (float) (rollingSpeed/Math.sqrt(2));
        rollCounter = rollDuration;
    }

    public void dodgeRollEnd(){
        isRolling = false;
        speed = normalSpeed;
        diagonalSpeed = normalSpeed;

    }
}
