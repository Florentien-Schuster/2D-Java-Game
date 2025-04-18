package weapons;

import java.awt.*;
import java.util.ArrayList;

public class Weapon {
    // WeaponDamageRange 0-100
    public int weaponDamagePhysical;
    public int weaponDamageMagical;
    public String weaponName;
    public String weaponEffect; // Passiv effects of the weapons itself (Basic)
    public double weaponAttackspeed; // WeaponAttackSpeedRange 0.5 - 2.00
    public int weaponDefensePhysical;
    public int weaponDefenseMagical;

    public Weapon(String weaponName, int weaponDamagePhysical,int weaponDamageMagical,double weaponAttackspeed,int weaponDefensePhysical,int weaponDefenseMagical, String weaponEffect){
        this.weaponName = weaponName;
        this.weaponDamagePhysical = weaponDamagePhysical;
        this.weaponDamageMagical = weaponDamageMagical;
        this.weaponAttackspeed = weaponAttackspeed;
        this.weaponDefensePhysical = weaponDefensePhysical;
        this.weaponDefenseMagical = weaponDefenseMagical;
        this.weaponEffect = weaponEffect;
    }
    Weapon dagger = new Weapon("Dagger",40,0,2.00,0,0,"Each hit applies a DOT with 5 poison damage per second.");
    Weapon greatsword = new Weapon("Greatsword",90,0,0.9,0,0,"With each hit there is a ... chance of stunning the enemy.");
    Weapon scythe = new Weapon("Scythe",30,30,1.40,0,0,"With each hit the player heals ... HP per hit.");
      Weapon wand = new Weapon("Wand",0,15,1.50,0,5,"With each hit the enemy gets cursed, physical & magical Defense -10.");
      Weapon swordAndShield = new Weapon("Sword & Shield",20,0,1.00,30,30,"");
      Weapon doubleSwords = new Weapon("Double Swords",50,0,1.70,0,0,"");
      Weapon bow = new Weapon("Bow",15,0,1.30,0,0,"You can equip different elemental arrows with unique effects.");
      Weapon crossbow = new Weapon("Crossbow",25,0,1.00,0,0,"With each hit you inflict a bleeding stack. With 10 bleeding stats do X damage to the target.");
      Weapon staff = new Weapon("Staff",0,70,1.2,0,0,"You can choose one element. Depending on the element your weapon gets unique passiv skills & your aktiv skills change.");
      Weapon spear = new Weapon("Spear",65,0,1.30,0,0,"");
      Weapon bullwark = new Weapon("Bullwark",0,0,1.00,20,20,"With Bullwark you cant attack, but you get a unique shield skill.");
      Weapon katana = new Weapon("Katana",60,0,1.4,0,0,"");
      Weapon kunai = new Weapon("Kunai",15,0,1.8,0,0,"");
      Weapon harp = new Weapon("Harp",0,5,1.6,10,10,"Depending on the chosen melody you get powerful buffs.");

}
