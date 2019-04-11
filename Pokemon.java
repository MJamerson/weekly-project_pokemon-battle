public class Pokemon{
	String name;
	int maxHealth;
	int health;
	boolean alive;

	public Pokemon(String name, int health){
		this.name = name;
		this.maxHealth = health;
		this.health = health;
		this.alive = true;
//		this.movelist = [["Scratch", 18, 25], ["Bite", 10, 35], ["Lick Wounds", 5, 20]];
	}
	
	public updateHealth(int amount){
		health += amount;
		if (health < 0){
			health = 0;
			alive = false;
		} else if (health > maxHealth){
			health = maxHealth;
		}
		return health;
	}
	
	public String getName(){
		return name;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getMaxHealth(){
		return maxHealth;
	}

	public boolean isAlive() {
		return alive;
	}
	
	public String toString(){
		return(this.getName() + " has " + this.getHealth() + "/ " + this.getMaxHealth() + " hp.");
	}
}