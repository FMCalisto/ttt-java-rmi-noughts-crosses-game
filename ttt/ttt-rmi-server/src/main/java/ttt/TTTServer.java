package ttt;

import java.io.IOException;
import java.net.ServerSocket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TTTServer {
	public static void main(String args[]) throws IOException {
		
		@SuppressWarnings("resource")
		ServerSocket s = new ServerSocket(0);		
		int registryPort = s.getLocalPort();
		System.out.println("listening on port: " + s.getLocalPort());
		
		System.out.println("Main OK");
		
		try {
			TTTService tttGame = new TTT();
			
			System.out.println("After create");
			
			Registry reg = LocateRegistry.createRegistry(registryPort);
			
			System.out.println("Local Registry OK");
			
			reg.rebind("TTT", tttGame);
			
			System.out.println("Rebind OK");
			
			System.out.println("TTT server ready");
			
		} catch(Exception e) {
			System.out.println("TTT server main " + e.getMessage());
		}
		
		System.out.println("Please start the client...");
		
	}

}