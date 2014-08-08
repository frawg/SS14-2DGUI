package Nodes;

import Globals.Globals.*;
import java.util.ArrayList;

public class SWITCH {
   private int id;
   private boolean isSelected;
   private ArrayList<String> [] switchTable;
   private STATUS status;
   
   public SWITCH(int id)
   {
       status = STATUS.UP;
       this.id = id;
       switchTable = new ArrayList[Globals.Globals.numbSwitchPorts]; // maximum 8 ports of a switch
       for(int i=0; i < Globals.Globals.numbSwitchPorts; i++){
           switchTable[i] = new ArrayList<String>();
           switchTable[i].add(i, null); // initialize the first element with null
           
           /* Adding fake entries for checking */
           switchTable[i].add(i,"AA-BB-CC-DD-EF-GH");
       }
   }
   public void setSelected(){ isSelected = Boolean.TRUE;}
   public void setUnSelected(){ isSelected = Boolean.FALSE;}
   public Boolean isSelected(){ 
       
       if(isSelected == Boolean.TRUE)
           return Boolean.TRUE;
       else 
           return Boolean.FALSE;
   }
   
   public int getID(){
       return id;
   }
   
    public STATUS getStatus(){
       return status;
    }   
    /* Network Switching related methods */
    public void recvPacket(){
        
    }
}
