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
