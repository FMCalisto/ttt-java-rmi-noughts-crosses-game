package ttt;

import java.rmi.RemoteException;
import java.util.Vector;
import java.awt.Graphics;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class TTTService extends UnicastRemoteObject implements TTTRemote {
	
	@SuppressWarnings("rawtypes")
	private static Vector tttList;
	private static int version;
	
	@SuppressWarnings("rawtypes")
	public TTTService() throws RemoteException {
    	tttList = new Vector();
    	version = 0;
    }
    
    @SuppressWarnings("unchecked")
	public TTTService newTTT(Graphics g) throws RemoteException {
    	version++;
    	TTTService ttt = new TTTService();
    	tttList.addElement(ttt);
    	return ttt;
    }
    
    @SuppressWarnings("rawtypes")
	public Vector allTTT() throws RemoteException {
    	return tttList;
    }
    
    public int getVersion() throws RemoteException {
    	return version;
    }

	@Override
	public TTT newTTT() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkWinner() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean play(int row, int column, int player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String currentBoard() {
		// TODO Auto-generated method stub
		return null;
	}
}
