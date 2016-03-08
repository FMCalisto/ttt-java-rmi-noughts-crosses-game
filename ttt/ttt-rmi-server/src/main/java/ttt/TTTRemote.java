package ttt;

import java.rmi.*;
import java.util.Vector;

public interface TTTRemote extends Remote{
	
	TTT newTTT() throws RemoteException;
	@SuppressWarnings("rawtypes")
	Vector allTTT() throws RemoteException;
	int getVersion() throws RemoteException;
	int checkWinner();
	boolean play(int row, int column, int player);
	String currentBoard() throws RemoteException;

}
