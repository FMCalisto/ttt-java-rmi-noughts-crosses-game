package ttt;
import java.rmi.*;

public class TTTClient {
	public static void main(String args[]) throws Exception {
   		/*if (System.getSecurityManager() == null){
        	System.setSecurityManager(new RMISecurityManager());
        } else{
            System.out.println("Already has a security manager, so cant set RMI SM");
        }*/
        TTTService tttService = null;
        try{
            tttService  = (TTTService) Naming.lookup("rmi://" + "localhost" +":"+8080+"/TTTService");
 			System.out.println("Found server");
 			Game g = new Game(tttService);
			g.playGame();
			g.congratulate();
		}catch(RemoteException e) {System.out.println("[REMOTE]:" + e.getMessage());
	    }catch(Exception e) {System.out.println("[Exception]:" + e.getMessage());}
    }
}

