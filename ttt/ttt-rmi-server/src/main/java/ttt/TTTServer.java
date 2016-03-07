package ttt;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TTTServer {
	public static void main(String args[]) {
		int registryPort = 8080;
		
		System.out.println("Main ok");
		
		try {
			TTTServer aTTT = new TTTServer();
			
			System.out.println("After create");
			
			Registry reg = LocateRegistry.createRegistry(registryPort);
			reg.rebind("TTT", (Remote) aTTT);
			
			System.out.println("TTT server ready");
			
		} catch(Exception e) {
			System.out.println("TTT server main " + e.getMessage());
		}
	}

}
