public class Pokemon{
	String name;
	int maxHealth;
	int health;

	public Pokemon(String name, int health){
		this.name = name;
		this.maxHealth = health;
		this.health = health;
	}
	
	public updateHealth(int amount){
		health += amount;
		if (health < 0){
			health = 0;
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
	
	public String toString(){
		return(this.getName() + " has " + this.getHealth() + "/ " + this.getMaxHealth() + " hp.");
	}
}