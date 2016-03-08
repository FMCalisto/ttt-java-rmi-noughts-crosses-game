package ttt;

import java.rmi.*;
import java.util.Scanner;

public class TTTClient {
	
//	int winner = -1;
//	static int player = 0;
	
	static Scanner keyboardSc;
	
	public static void main(String[] args) throws Exception {
		int play;
		int cont = 0;
		int winner = -1;
		int player = 0;
		boolean acceptedPlay;
		boolean restart;
		
		try {
			System.out.println("Port search...");
			TTTService game = (TTTService) Naming.lookup("//localhost:8080/TTT");
			System.out.println("Port connection accepted");
			
			do{
		 		restart=false;
				do {
					player = ++player % 2;
					do {
						System.out.println(game.currentBoard());
						//play = readPlay();					
						do {
							System.out.printf("\nPlayer %d, please enter the number of the square "
											+ "where you want to place your %c (or 0 to refresh the board): \n",
											player, (player == 1) ? 'X' : 'O');
							play = keyboardSc.nextInt();
						} while (play > 10 || play < 0);
						//
						if (play != 0) {
							if(play==10){
								int last=game.lastPlay(player);
								if(last!=-1){
									System.out.println("Last play was: " + last +" by player " + player);
								}else{
									System.out.println("No plays made by player " + player);
								}
								acceptedPlay = false;
								continue;
							}
							acceptedPlay = game.play( --play / 3, play % 3, player);
							if (!acceptedPlay)
								System.out.println("Invalid play! Try again.");
						} else
							acceptedPlay = false;
					} while (!acceptedPlay);
					winner = game.checkWinner();
				} while (winner == -1);
	
				if (winner == 2)
					System.out.printf("\nHow boring, it is a draw\n");
				else
					System.out.printf(
							"\nCongratulations, player %d, YOU ARE THE WINNER!\n",
							winner);
				do{
					System.out.println("Restart the game? (yes = 1/no = 2): ");
					cont = keyboardSc.nextInt();
				}while(cont < 1 || cont> 2);
				
				if(cont == 1){
	  				game.restart();
	  				restart=true;
	  				play=0;
	  				player = 1;
	  				cont= 0;
	  				}
	
	 		}while(restart);
	 		
			}catch(RemoteException e){
				System.out.println("TTT:"+ e.getMessage());
			}
		}

}