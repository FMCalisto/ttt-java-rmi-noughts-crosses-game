package ttt;

import java.util.Vector;

public class Game {

    @SuppressWarnings({ "rawtypes", "null" })
	public static void main(String[] args) throws Exception {
    	  String option = "Read";
    	  String playType = "Play";
    	  
    	  if (args.length > 0) {
    		  option = args[0]; // read or write
    	  }
    	  if (args.length > 1) {
    		  playType = args[1]; // specify Play, Stop, etc...
    	  }
    	  
    	  System.out.println("option: " + option + "play: " + playType);
    	  TTT aTTT = null; //FIXME: Delete TTT.java Interface & File
    	  
    	  try {
//    		  aTTT = (TTT)Naming.lookup("//");
			  Vector tttList = aTTT.allTTT();
//    		  System.out.println("Got vector");
    		  
    		  if (option.equals("Read")) {
    			  for (int i = 0; i < tttList.size(); i++) {
//    				  GraphicalObject g = ((TTT) tttList.elementAt(i)).getAllState();
//    				  g.print();
    			  }
    		  } else {
    			  // GraphicalObject g = new GraphicalObject(playType);
    			  
    			  System.out.println("Created TTT object");
    			  // aTTT.newTTT(g);
    			  System.out.println("Stored");
    		  }
    		  
    	  } catch(Exception e) {
    		  System.out.println("Lookup: " + e.getMessage());
    	  }
    }

}
