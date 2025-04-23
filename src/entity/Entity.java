package entity;

import weapons.Weapon;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Entity {
    public int worldX,worldY;
    public int speed;
    public float diagonalSpeed;

    public BufferedImage spriteSheetRunningRight,spriteSheetRunningLeft,spriteSheetIdleDown;
    public BufferedImage[] ocRunningRight,ocRunningLeft,ocIdleDown;
    public BufferedImage idle_test, idle_down1, idle_down2, idle_up1, idle_up2, idle_left1, idle_left2, idle_right1, idle_right2;
    public String direction;
    static public int spriteCounter = 0;
    static public int spriteNum = 1;
    public Rectangle solidArea; // (x,y,width,height)
    public boolean collisionOn = false;
    public int healthPoints;
    public int mana;
    public int rage;
    public int stamina;
    public int playerDamage;
    public int playerMagicDamage;
    public int playerPhysicalDamage;
    public int enemyDamage;
    public double attackSpeed;
    public double physicalDefense;
    public double magicalDefense;
    //public List<Weapon> equippedWeapons = new ArrayList<>(); // max 2 weapons equipped
    /* Idea: weaponcombination is "class" like ranger etc. and skills depend on combination */



}
