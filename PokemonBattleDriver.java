public static void main(String [] args){
	initializePokemon();
	beginBattle();
	printResults();
}

public void initializePokemon(){
	Pokemon player = new Pokemon("Pikachu", 100);
	player.toString();
}