package Models;

import java.util.Random;

public class MobStats
{
	public static Stats PlayerLVL1 =  new Stats(50,  10, 10, 0.2,  10);
	public static Stats PlayerLVL2 =  new Stats(75,  15, 15, 0.25, 15);
	public static Stats PlayerLVL3 =  new Stats(100, 20, 20, 0.3,  20);
	public static Stats PlayerLVL4 =  new Stats(125, 25, 25, 0.4,  25);

	public static Stats EnemyLVL1 =   new Stats(30,  10, 5,  0.1,  20);
	public static Stats EnemyLVL2 =   new Stats(50,  10, 10, 0.1,  20);
	public static Stats EnemyLVL3 =   new Stats(70,  15, 15, 0.2,  20);
	public static Stats EnemyLVL4 =   new Stats(100, 20, 20, 0.2,  20);
	
	public static Stats Boss =        new Stats(125, 25, 30, 0.5,  0);

	private static Stats SwordLVL1 =  new Stats(0,    0,  2, 0.0,  5);
	private static Stats SwordLVL2 =  new Stats(0,    0,  6, 0.05, 5);
	private static Stats SwordLVL3 =  new Stats(0,    0, 14, 0.1,  5);
	private static Stats SwordLVL4 =  new Stats(0,    0, 19, 0.15, 5);

	private static Stats ArmourLVL1 = new Stats(0,    5,  0,   0,  5);
	private static Stats ArmourLVL2 = new Stats(0,    8,  0,   0,  5);
	private static Stats ArmourLVL3 = new Stats(0,   17,  0,   0,  5);
	private static Stats ArmourLVL4 = new Stats(0,   23,  0,   0,  5);
	
	private static Random rng = new Random();

	public static Stats SwordLVL1()
	{
		Stats sword = SwordLVL1;
		sword.setDamage(sword.getDamage() + rng.nextInt(3));
		sword.setLuck(sword.getLuck() + rng.nextInt(10)/100);
		return sword;
	}
	
	public static Stats SwordLVL2()
	{
		Stats sword = SwordLVL2;
		sword.setDamage(sword.getDamage() + rng.nextInt(6));
		sword.setLuck(sword.getLuck() + rng.nextInt(15)/100);
		return sword;
	}
	
	public static Stats SwordLVL3()
	{
		Stats sword = SwordLVL3;
		sword.setDamage(sword.getDamage() + rng.nextInt(4));
		sword.setLuck(sword.getLuck() + rng.nextInt(20)/100);
		return sword;
	}

	public static Stats SwordLVL4()
	{
		Stats sword = SwordLVL4;
		sword.setDamage(sword.getDamage() + rng.nextInt(6));
		sword.setLuck(sword.getLuck() + rng.nextInt(25)/100);
		return sword;
	}

	public static Stats ArmourLVL1()
	{
		Stats armour = ArmourLVL1;
		armour.setEndurance(armour.getEndurance() + rng.nextInt(5));
		armour.setHealth(armour.getHealth() + rng.nextInt(7));
		return armour;
	}
	public static Stats ArmourLVL2()
	{
		Stats armour = ArmourLVL2;
		armour.setEndurance(armour.getEndurance() + rng.nextInt(7));
		armour.setHealth(armour.getHealth() + rng.nextInt(5));
		return armour;
	}
	public static Stats ArmourLVL3()
	{
		Stats armour = ArmourLVL3;
		armour.setEndurance(armour.getEndurance() + rng.nextInt(5));
		armour.setHealth(armour.getHealth() + rng.nextInt(5));
		return armour;
	}
	public static Stats ArmourLVL4()
	{
		Stats armour = ArmourLVL4;
		armour.setEndurance(armour.getEndurance() + rng.nextInt(7));
		armour.setHealth(armour.getHealth() + rng.nextInt(6));
		return armour;
	}
}