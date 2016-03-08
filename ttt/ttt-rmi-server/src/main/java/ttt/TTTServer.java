package ttt;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TTTServer {
	public static void main(String args[]) {
		int registryPort = 8080;
		
		System.out.println("Main OK");
		
		try {
			TTT aTTT = new TTT();
			
			System.out.println("After create");
			
			Registry reg = LocateRegistry.createRegistry(registryPort);
			
			System.out.println("Local Registry OK");
			
			reg.rebind("TTT", aTTT);
			
			System.out.println("Rebind OK");
			
			System.out.println("TTT server ready");
			
		} catch(Exception e) {
			System.out.println("TTT server main " + e.getMessage());
		}
	}

}


//package ttt;
//
//import java.rmi.*;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//
//public class TTTServer {
//
//	public static void main(String[] args) {
//		int resgistryPort = 1098;
//		System.out.println("Main ok");
//		try{
//			TTTService ttt_game = new TTT();
//			System.out.println("After Complete");
//			
//			Registry reg= LocateRegistry.createRegistry(resgistryPort);
//			reg.rebind("TTT", ttt_game);
//			
//		}catch(Exception e){
//			System.out.println("TTTServer main " + e.getMessage());
//		}
//
//		System.out.println("OUT");
//	}
//}
