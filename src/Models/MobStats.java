package Models;

import java.util.Random;

/**
 * @author joh
 * @version 2015-03-07
 */
public class MobStats
{
    /**
     * @return player Stats for lvl 1
     */
    public static Stats getPlayerLVL1() {
        return new Stats(50,  10, 10, 0.2,  10);
    }
    
    /**
     * @return player Stats for lvl 2
     */
    public static Stats getPlayerLVL2() {
        return new Stats(75,  15, 15, 0.25, 15);
    }
    
    /**
     * @return player Stats for lvl 3
     */
    public static Stats getPlayerLVL3() {
        return new Stats(100, 20, 20, 0.3,  20);
    }
    
    /**
     * @return player Stats for lvl 4
     */
    public static Stats getPlayerLVL4() {
        return new Stats(125, 25, 25, 0.4,  25);
    }

	private static Stats SwordLVL1 =  new Stats(0,    0,  2, 0.0,  5);
	private static Stats SwordLVL2 =  new Stats(0,    0,  6, 0.05, 5);
	private static Stats SwordLVL3 =  new Stats(0,    0, 14, 0.1,  5);
	private static Stats SwordLVL4 =  new Stats(0,    0, 19, 0.15, 5);

	private static Stats ArmourLVL1 = new Stats(5,    5,  0,   0,  5);
	private static Stats ArmourLVL2 = new Stats(13,   8,  0,   0,  5);
	private static Stats ArmourLVL3 = new Stats(20,  17,  0,   0,  5);
	private static Stats ArmourLVL4 = new Stats(26,  23,  0,   0,  5);
	
	private static Random rng = new Random();

	/**
	 * @return sword Stats for Sword lvl 1
	 */
	public static Stats SwordLVL1()
	{
		Stats sword = SwordLVL1;
		sword.setDamage(sword.getDamage() + rng.nextInt(3));
		sword.setLuck(sword.getLuck() + rng.nextInt(10)/100);
		return sword;
	}
	
	/**
	 * @return sword Stats for Sword lvl 2
	 */
	public static Stats SwordLVL2()
	{
		Stats sword = SwordLVL2;
		sword.setDamage(sword.getDamage() + rng.nextInt(6));
		sword.setLuck(sword.getLuck() + rng.nextInt(15)/100);
		return sword;
	}
	
	/**
	 * @return sword Stats for Sword lvl 3
	 */
	public static Stats SwordLVL3()
	{
		Stats sword = SwordLVL3;
		sword.setDamage(sword.getDamage() + rng.nextInt(4));
		sword.setLuck(sword.getLuck() + rng.nextInt(20)/100);
		return sword;
	}

	/**
	 * @return sword Stats for Sword lvl 4
	 */
	public static Stats SwordLVL4()
	{
		Stats sword = SwordLVL4;
		sword.setDamage(sword.getDamage() + rng.nextInt(6));
		sword.setLuck(sword.getLuck() + rng.nextInt(25)/100);
		return sword;
	}

	/**
	 * @return armour Stats for Armour lvl 1
	 */
	public static Stats ArmourLVL1()
	{
		Stats armour = ArmourLVL1;
		armour.setEndurance(armour.getEndurance() + rng.nextInt(5));
		armour.setHealth(armour.getHealth() + rng.nextInt(7));
		return armour;
	}
	/**
	 * @return armour Stats for Armour lvl 2
	 */
	public static Stats ArmourLVL2()
	{
		Stats armour = ArmourLVL2;
		armour.setEndurance(armour.getEndurance() + rng.nextInt(7));
		armour.setHealth(armour.getHealth() + rng.nextInt(5));
		return armour;
	}
	
	/**
	 * @return armour Stats for Armour lvl 3
	 */
	public static Stats ArmourLVL3()
	{
		Stats armour = ArmourLVL3;
		armour.setEndurance(armour.getEndurance() + rng.nextInt(5));
		armour.setHealth(armour.getHealth() + rng.nextInt(5));
		return armour;
	}
	
	/**
	 * @return armour Stats for Armour lvl 4
	 */
	public static Stats ArmourLVL4()
	{
		Stats armour = ArmourLVL4;
		armour.setEndurance(armour.getEndurance() + rng.nextInt(7));
		armour.setHealth(armour.getHealth() + rng.nextInt(6));
		return armour;
	}
    
    /**
     * @return Stats for Boss
     */
    public static Stats getBoss() {
        return new Stats(125, 25, 30, 0.5,  0);
    }

    /**
     * @return enemy Stats for lvl 1
     */
    public static Stats getEnemyLVL1() {
        return new Stats(30,  10, 5,  0.1,  20);
    }

    /**
     * @return enemy Stats for lvl 2
     */
    public static Stats getEnemyLVL2() {
        return new Stats(50,  10, 10, 0.1,  20);
    }


    /**
     * @return enemy Stats for lvl 3
     */
    public static Stats getEnemyLVL3() {
        return new Stats(70,  15, 15, 0.2,  20);
    }

    /**
     * @return enemy Stats for lvl 4
     */
    public static Stats getEnemyLVL4() {
        return new Stats(100, 20, 20, 0.2,  20);
    }
}