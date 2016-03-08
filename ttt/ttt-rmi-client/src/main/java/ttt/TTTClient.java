package ttt;

import java.rmi.*;
import java.util.Scanner;

public class TTTClient {
	
	int winner = -1;
	int player = 0;
	
	static Scanner keyboardSc;
	
	public static void main(String[] args) throws Exception {
		int play;
		int cont = 0;
		boolean acceptedPlay;
		boolean restart;
		
		try {
			TTTService game = Naming.lookup("//localhost:8080/TTT");
		}
	}

}
