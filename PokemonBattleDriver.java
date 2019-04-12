import java.util.Scanner;
import java.lang.Math;

public class PokemonBattleDriver{
	public static void main(String [] args){
		doBattle();
	}

	public static void doBattle(){
		Scanner r = new Scanner(System.in);
		Pokemon player = new Pokemon("Pikachu", 100);
		Pokemon enemy = new Pokemon("Meowth", 100);
		while(true){
			System.out.println(player.toString());
			System.out.println(enemy.toString());
			Move playerMove = selectMove(r, player);
			Move enemyMove = aiSelectMove(enemy);
			doMoves(player, playerMove, enemy, enemyMove);
			if(!player.isAlive() && !enemy.isAlive()){
				System.out.println("Both players have fainted..?! Tie match!");
			}else if(!player.isAlive()){
				System.out.println(player.getName() + " has fainted! Better luck next time!");
				break;
			} else if (!enemy.isAlive()){
				System.out.println(enemy.getName() + " has fainted! Congratulations!");
				break;
			}
		}
		r.close();
	}

	public static Move selectMove(Scanner r, Pokemon player){
		int tempCntr = 1;
		int choice;
		String menu = "";
		Move[] moveList = player.getMoveList();
		for (Move curMove : moveList){
			menu += "" + (tempCntr++) + ") " + curMove.toString() + "\n";
		}
		menu += "What will " + player.getName() + " do?: ";

		while(true){
			try{
				System.out.print(menu);
				choice = r.nextInt();
				if (choice < 1 || choice > moveList.length){
					throw new IllegalArgumentException("Invalid menu choice!");
				} else {
					return moveList[(choice - 1)];
				}
			} catch (Exception e){
				System.out.println("Please select a valid menu choice!\n\n");
			}
		}
	}

	public static Move aiSelectMove(Pokemon enemy){
		Move[] moveList = enemy.getMoveList();
		int rand = (int) ((Math.random() * 8) + 1);
		if((enemy.getHealth() / enemy.getMaxHealth()) > 0.35){ // Move chance split 3/9 per move
			if(rand <= 3){
				return moveList[0];
			} else if (rand <= 6){
				return moveList[1];
			} else{
				return moveList[2];
			}
		} else{ // Low health. Heal chance increased (2/9, 2/9, 5/9)
			if(rand <= 2){
				return moveList[0];
			} else if(rand <= 4){
				return moveList[1];
			} else{
				return moveList[2];
			}
		}
	}

	public static void doMoves(Pokemon player, Move playerMove, Pokemon enemy, Move enemyMove){
		if(playerMove.getDamMax() > 0){
			enemy.updateHealth(-1 * rollDamage(playerMove));
		} else{
			player.updateHealth(rollDamage(playerMove));
		}
		if(enemy.isAlive()){
			if(enemyMove.getDamMax() > 0){
				player.updateHealth(-1 * rollDamage(enemyMove));
			} else{
				enemy.updateHealth(rollDamage(enemyMove));
			}
		}
	}

	public static int rollDamage(Move currMove){
		return (int) Math.abs(((Math.random() * (currMove.getDamMax() - currMove.getDamMin())) + currMove.getDamMin()));
	}
}