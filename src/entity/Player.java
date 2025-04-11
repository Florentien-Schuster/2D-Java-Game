package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_right2.png"));
            idle_down1 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_idle_down1.png"));
            idle_down2 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_idle_down2.png"));
            idle_left1 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_idle_left1.png"));
            idle_left2 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_idle_left2.png"));
            idle_right1 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_idle_right1.png"));
            idle_right2 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_idle_right2.png"));
            idle_up1 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_idle_up1.png"));
            idle_up2 = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_idle_up2.png"));
            // idle_test = ImageIO.read(getClass().getResourceAsStream("/Player/OC/2D_game_OC_idle1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if (keyH.upPressed){
                direction = "up";
                y -= speed;
            }else if(keyH.downPressed){
                direction = "down";
                y += speed;
            }else if(keyH.leftPressed){
                direction = "left";
                x -= speed;
            }else if(keyH.rightPressed){
                direction = "right";
                x += speed;
            }
            animationLoader(15);
        }else{
            animationLoader(40);
        }
    }
    public void draw(Graphics2D g2){

        //g2.setColor(Color.white);
        //g2.fillRect(x,y,gp.tileSize,gp.tileSize); // size & position player
        BufferedImage image = null;
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            switch(direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
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
                    if (spriteNum == 1) {
                        image = idle_down1;
                    }
                    if (spriteNum == 2) {
                        image = idle_down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = idle_left1;
                    }
                    if (spriteNum == 2) {
                        image = idle_left2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = idle_right1;
                    }
                    if (spriteNum == 2) {
                        image = idle_right2;
                    }
            }
        }
        g2.drawImage(image, x,y,gp.tileSize,gp.tileSize,null);
    }
    public void animationLoader(int counter) {
        spriteCounter++;
        if (spriteCounter > counter) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
}
