package Nodes;

import Globals.Globals.*;
import java.util.ArrayList;

public class LINK {
   private String guiID;
   
   private int id;
   private boolean isSelected;
   private ArrayList<String> [] switchTable;
   private String [] switchPorts = new String [Globals.Globals.numbSwitchPorts];
   private STATUS status;
   
   public LINK(int id)
   {
       status = STATUS.UP;
       this.id = id;
       guiID = "Link"+this.id;
       switchTable = new ArrayList [Globals.Globals.numbSwitchPorts]; // 16 ports of a switch
       for(int i=0; i < Globals.Globals.numbSwitchPorts; i++){
           String s = Globals.Parser.generateRandomMAC(); 
           switchPorts[i]=s;
       }
   }
   public void setSelected(){ isSelected = Boolean.TRUE;}
   public void setUnSelected(){ isSelected = Boolean.FALSE;}
   public Boolean isSelected(){ 
       if (isSelected == Boolean.TRUE)
           return Boolean.TRUE;
       else 
           return Boolean.FALSE;
   }
   public String getguiID(){ return guiID; }
   public void setguiID(String id){ guiID=id; }
   public int getID(){ return id; }
   
    public STATUS getStatus(){
       return status;
    }   

    /* Network Switching related methods */
    public void recvPacket(){ }
    
    public String getMACAddress(int i){
        return switchPorts[i];
    }
}
