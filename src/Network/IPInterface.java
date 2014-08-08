package Network;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class IPInterface {
    private String macAddress;
    private String ipAddress;
    private String interfaceID;
    
    public IPInterface(){
        ipAddress = Globals.Parser.getNextGlobalIPAddress();   
        macAddress = Globals.Parser.generateRandomMAC();
        interfaceID = "1";
    }
    
    public String getIPAddress(){
        return ipAddress;
    }
    
    public void setIPAddress(String ip){
       StringTokenizer st = new StringTokenizer(ip, ".");
       if(st.countTokens() > 4){          
           return;
       }
       while(st.hasMoreElements()){
	  if(Integer.parseInt(st.nextElement().toString()) < 0 ||
                 Integer.parseInt(st.nextElement().toString()) > 255){
                 System.err.println("Error in IP Address");
                 return;
          }
       }
        ipAddress=ip;
    }   
    
    public String getMACAddress(){
        return macAddress;
    }
    
     
    public String getinterfaceID(){
        return interfaceID;
    }            
        
} 