import java.util.Scanner;
import java.util.Math;
Scanner r = new Scanner(System.in);

Pokemon player = new Pokemon("Pikachu", 100);
Pokemon enemy = new Pokemon("Meowth", 100);

public static void main(String [] args){
	doBattle();
	printResults();
}

public void doBattle(){
	while(true){
		playerMove = selectMove();
		enemyMove = aiSelectMove();
		doMoves(playerMove, enemyMove);
		if(!player.isAlive() && !enemy.isAlive()){
			system.out.println("Both players have fainted! Tie match!");
		}else if(!player.isAlive()){
			system.out.println(player.getName() + " has fainted! Better luck next time!");
			break;
		} else if (!enemy.isAlive()){
			system.out.println(enemy.getName() + " has fainted! Congratulations!");
			break;
		}
	}
}

public Move selectMove(){
	int tempCntr = 0;
	int choice;
	String menu = "";
	Move[] moveList = player.getMoveList();
	for (curMove in moveList){
		menu += "" + (i++) + ") " + curMove.toString() + "\n";
	}
	menu += "Select move: ";

	while(true){
		try{
			System.out.print(menu);
			choice = r.nextInt();
			if (choice < 1 || choice > moveList.length){
				throw new IllegalArgumentException("Invalid menu choice!");
			} else{
				return moveList[choice--];
			}
		}
		} catch (Exception e){
			System.out.println("Please select a valid menu choice!\n\n")
		}
	}
}

public Move aiSelectMove(){
	Move[] moveList = enemy.getMoveList();

}