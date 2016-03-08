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

			public Game() {
				ttt = new TTT();
				keyboardSc = new Scanner(System.in);
			}

			public int readPlay() {
				int play;
				do {
					System.out.printf("\nPlayer %d, please enter the number of the square "
									+ "where you want to place your %c (or 0 to refresh the board): \n",
									player, (player == 1) ? 'X' : 'O');
					play = keyboardSc.nextInt();
				} while (play > 9 || play < 0);
				return play;
			}

			public void playGame() {
				int play;
				boolean playAccepted;

				do {
					player = ++player % 2;
					do {
						System.out.println(ttt.currentBoard());
						play = readPlay();
						if (play != 0) {
							playAccepted = ttt.play( --play / 3, play % 3, player);
							if (!playAccepted)
								System.out.println("Invalid play! Try again.");
						} else
							playAccepted = false;
					} while (!playAccepted);
					winner = ttt.checkWinner();
				} while (winner == -1);
			}

			public void congratulate() {
				if (winner == 2)
					System.out.printf("\nHow boring, it is a draw\n");
				else
					System.out.printf(
							"\nCongratulations, player %d, YOU ARE THE WINNER!\n",
							winner);
			}

			public static void main(String[] args) {
				Game g = new Game();
				g.playGame();
				g.congratulate();
			}
	
	 		}while(restart);
	 		
			}catch(RemoteException e){
				System.out.println("TTT:"+ e.getMessage());
			}
		}

}