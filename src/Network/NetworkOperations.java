package Network;

import java.util.StringTokenizer;

public class NetworkOperations {
   static public boolean validateIPAddress(String ip){
      
     //boolean status = checkIPAlreadyAssigned(ip);
     //if(status == true)
     //    return false;
       
     StringTokenizer st = new StringTokenizer(ip, ".");
     if(st.countTokens() > 4){          
        return false;
      }
    try{
     while(st.hasMoreElements()){        
       if(Integer.parseInt(st.nextElement().toString()) < 0 ||
           Integer.parseInt(st.nextElement().toString()) > 255){
           System.err.println("Error in IP Address");
           return false;
        }
       }
     }catch(NumberFormatException e){
       return false;
    }
       return true;
  }
   
   /*static public String checkIPAlreadyAssigned(String ip){
     // First check all computers //
   }*/
}
