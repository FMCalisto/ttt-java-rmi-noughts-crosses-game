package ttt;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class TTT extends UnicastRemoteObject implements TTTService {
	
	private static final long serialVersionUID = 1L;
	
	private int _lastMovePlayer1 = -1;
	private int _lastMovePlayer2 = -1;	
	
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
		nextPlayer = 0; //FIX
		numPlays = 0;
		_lastMovePlayer1 = 0;
		_lastMovePlayer2 = 0;
		
	}
	
	public int lastPlay(int player) {
		if(player == 1) {
			return _lastMovePlayer1;
		} else {
			return _lastMovePlayer2;
		}
	}

//	@Override
//	public TTT newTTT() throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@SuppressWarnings("rawtypes")
//	@Override
//	public Vector allTTT() throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int getVersion() throws RemoteException {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}

//package ttt;
//
//import java.rmi.*;
//import java.rmi.server.UnicastRemoteObject;
//
//public class TTT extends UnicastRemoteObject implements TTTService{
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	protected TTT() throws RemoteException {}
//	private int _lastMove_player1=-1;
//	private int _lastMove_player2=-1;
//	
//	char board[][] = {
//		  {'1','2','3'},          /* Initial values are reference numbers */
//		  {'4','5','6'},          /* used to select a vacant square for   */
//		  {'7','8','9'}           /* a turn.                              */
//		};
//	int nextPlayer = 0;
//	int numPlays = 0;
//
//    public String currentBoard() {
//    	String s = "\n\n " + 
//    				board[0][0]+" | " +
//    				board[0][1]+" | " +
//    				board[0][2]+" " +
//    				"\n---+---+---\n " +
//    				board[1][0]+" | " +
//    				board[1][1]+" | " +
//    				board[1][2]+" " +
//    				"\n---+---+---\n " +
//    				board[2][0]+" | " +
//    				board[2][1]+" | " +
//    				board[2][2] + " \n";
//    	return s;
//    }
//
//    public boolean play(int row, int column, int player) {
//    	int _move = row * 3 + column +1;
//    	
//    	
//		if (!(row >=0 && row <3 && column >= 0 && column < 3))
//			return false;
//		if (board[row][column] > '9')
//			return false;
//		if (player != nextPlayer) 
//			return false;
//
//		if (numPlays == 9) 
//			return false;
//
//		board[row][column] = (player == 1) ? 'X' : 'O';        /* Insert player symbol   */
//		
//		if(player==1){
//			_lastMove_player1=_move;
//		}else{
//			_lastMove_player2=_move;
//		}
//		
//		nextPlayer = (nextPlayer + 1) % 2;
//		numPlays ++;
//		return true;	
//    }
//
//    public int checkWinner() {
//    	  int i;
//    	  /* Check for a winning line - diagonals first */     
//    	  if((board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
//    	     (board[0][2] == board[1][1] && board[0][2] == board[2][0])) {
//    		  if (board[1][1]=='X')
//    			  return 1;
//    		  else 
//    			  return 0;
//    	  }
//    	  else
//    	    /* Check rows and columns for a winning line */
//    	    for(i = 0; i <= 2; i ++){
//    	      if((board[i][0] == board[i][1] && board[i][0] == board[i][2])) {
//    	    	  if (board[i][0]=='X')
//    	    		  return 1;
//    	    	  else 
//    	    		  return 0;
//    	      }
//
//    	     if ((board[0][i] == board[1][i] && board[0][i] == board[2][i])) {
//    	    	 if (board[0][i]=='X') 
//    	    		 return 1;
//    	    	 else 
//    	    		 return 0;
//    	     }
//    	    }
//    	  	if (numPlays == 9)
//    	  		return 2; /* A draw! */
//    	  	else
//    	  		return -1; /* Game is not over yet */
//	}
//    
//    public void restart(){
//    	 char copyBoard[][] = {
//    			  {'1','2','3'},
//    			  {'4','5','6'},
//    			  {'7','8','9'}
//    			};
//    	 board= copyBoard;
//    		nextPlayer = 0;
//    		numPlays = 0;
//    		_lastMove_player1=0;
//    		_lastMove_player2=0;
//    }
//    
//    public int lastPlay(int player){
//    	if(player==1){
//    		return _lastMove_player1;
//    	}else{
//    		return _lastMove_player2;
//    	}
//    }
//
//}
