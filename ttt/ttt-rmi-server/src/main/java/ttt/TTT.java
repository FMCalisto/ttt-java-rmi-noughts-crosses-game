package ttt;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.LinkedList;



public class TTT extends UnicastRemoteObject implements TTTService {
	
    public class jogada {
        public int row;
        public int column;
        public int player;

        public jogada(int _row, int _column, int _player){
            row = _row;
            column = _column;
            player = _player;
        }

        public int getRow(){
            return row;
        }
        public int getColumn(){
            return column;
        }
        public int getPlayer(){
            return player;
        }
    }

    LinkedList<TTT.jogada> Jogadas = new LinkedList<TTT.jogada>();

	private static final long serialVersionUID = 1L;
	
	protected TTT() throws RemoteException{
		//TODO
	}
	
	char board[][] = {
		  {'1','2','3'},          /* Initial values are reference numbers */
		  {'4','5','6'},          /* used to select a vacant square for   */
		  {'7','8','9'}           /* a turn.                              */
		};
	
	int nextPlayer = 0;
	int numPlays = 0;
	
	public String currentBoard() {
    	String s = "\n\n " + 
    				board[0][0]+" | " +
    				board[0][1]+" | " +
    				board[0][2]+" " +
    				"\n---+---+---\n " +
    				board[1][0]+" | " +
    				board[1][1]+" | " +
    				board[1][2]+" " +
    				"\n---+---+---\n " +
    				board[2][0]+" | " +
    				board[2][1]+" | " +
    				board[2][2] + " \n";
    	return s;
    }

    public boolean play(int row, int column, int player) {
		if (!(row >=0 && row <3 && column >= 0 && column < 3))
			return false;
		if (board[row][column] > '9')
			return false;
		if (player != nextPlayer) 
			return false;

		if (numPlays == 9) 
			return false;


        Jogadas.add(new TTT.jogada(row, column, player));

		board[row][column] = (player == 1) ? 'X' : 'O';        /* Insert player symbol   */
		nextPlayer = (nextPlayer + 1) % 2;
		numPlays ++;
		return true;	
    }

    public int checkWinner() {
    	  int i;
    	  /* Check for a winning line - diagonals first */     
    	  if((board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
    	     (board[0][2] == board[1][1] && board[0][2] == board[2][0])) {
    		  if (board[1][1]=='X')
    			  return 1;
    		  else 
    			  return 0;
    	  }
    	  else
    	    /* Check rows and columns for a winning line */
    	    for(i = 0; i <= 2; i ++){
    	      if((board[i][0] == board[i][1] && board[i][0] == board[i][2])) {
    	    	  if (board[i][0]=='X')
    	    		  return 1;
    	    	  else 
    	    		  return 0;
    	      }

    	     if ((board[0][i] == board[1][i] && board[0][i] == board[2][i])) {
    	    	 if (board[0][i]=='X') 
    	    		 return 1;
    	    	 else 
    	    		 return 0;
    	     }
    	    }
    	  	if (numPlays == 9)
    	  		return 2; /* A draw! */
    	  	else
    	  		return -1; /* Game is not over yet */
	}
	
	public void restart() {
		char boardRestart[][] = {
				  {'1','2','3'},          /* Initial values are reference numbers */
				  {'4','5','6'},          /* used to select a vacant square for   */
				  {'7','8','9'}           /* a turn.                              */
				};
		
		board = boardRestart;
		nextPlayer = 0;
		numPlays = 0;		
	}
	

    public void removeLastPlay(){
        int _column, _row;

        for(int k=2; k>0; k--){
            if(Jogadas.size() > 0){
                _row = Jogadas.getLast().getRow();
                _column = Jogadas.getLast().getColumn();

                board[_row][_column] = (char) (48 + (( (3*_row) + (1+_column))));

                numPlays--;
                Jogadas.removeLast();
            }
        }
    }
}