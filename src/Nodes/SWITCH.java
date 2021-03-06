package Nodes;

import Globals.Globals.*;

import java.awt.Point;
import java.util.ArrayList;

public class SWITCH {
	   private String guiID;
   private int id;
   private boolean isSelected;
   private ArrayList<String> [] switchTable;
   private String [] switchPorts = new String [Globals.Globals.numbSwitchPorts];
   private STATUS status;
   private Point position;
   
   public SWITCH(int id)
   {
       status = STATUS.UP;
       this.id = id;
       guiID = "Switch" + this.id;
       switchTable = new ArrayList[Globals.Globals.numbSwitchPorts]; // maximum 8 ports of a switch
       for(int i=0; i < Globals.Globals.numbSwitchPorts; i++){
           /* Adding fake entries for checking */
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
   public void setguiID(String id){ guiID = id; }
   public int getID(){
       return id;
   }
   
   public ArrayList<String>[] getSwitchTable() { return switchTable; }
   
    public STATUS getStatus(){
       return status;
    }   
    /* Network Switching related methods */
    public void recvPacket(){ }

    public String getMACAddress(int i){
        return switchPorts[i];
    }
    
    public void setPosition(int x, int y){
        position.x = x;
        position.y = y;
    }
}
