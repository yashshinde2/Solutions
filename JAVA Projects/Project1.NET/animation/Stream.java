  /*
     Nadeem Kinikar				
	     AND
      Mohd.Sadiq                                                                             
*/ 											            
import java.awt.*;

abstract class Stream implements Runnable {
   TokenObject value;
   Thread runner = null;
   
   public Stream ()  {  }
   
   synchronized public void putIt (TokenObject t) {
      value = t;
      notify ();
      if (value != null) try {  wait ();  } catch (Exception e) {  }
   }

   synchronized public TokenObject next () {
      if (runner != null)  notify ();
      else {
         runner = new Thread(this);
         runner.start();
      }

      try {  wait (); } catch (Exception e) {  }
      return value;
   }
}
