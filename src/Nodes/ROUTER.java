package Nodes;

import java.awt.Point;

import Globals.Globals.*;
import Network.*;

public class ROUTER {
   private String guiID;
   private int id;
   private int recvBuffer;
   private int sendBuffer;
   private boolean isSelected;
   public IPInterface ipInterface;   
   private STATUS status;
   private Point position;

   public ROUTER(int id)
   {
       status = STATUS.UP;
       this.id = id;
       guiID = "Router" + this.id;
       ipInterface = new IPInterface();  // creating this also assigns global IP dynamically.
       recvBuffer=100; // default 100 packets
       sendBuffer=100; // detault 100 packets
   }
   
   public void setSelected(){ isSelected = Boolean.TRUE;}
   public void setUnSelected(){ isSelected = Boolean.FALSE;}
   public Boolean isSelected(){ 
       if (isSelected == Boolean.TRUE)
           return Boolean.TRUE;
       else 
           return Boolean.FALSE;
   }
   
   public int getID(){ return id; }
   
   public String getguiID(){ return guiID; }
   public void setguiID(String id){ guiID = id; }
      
   public int getrecvBuffer(){ return recvBuffer; }
   public void setrecvBuffer(int buff){ recvBuffer = buff; }
   public int getsendBuffer(){ return sendBuffer; }
   public void setsendBuffer(int buff){ sendBuffer = buff; }
   
   public STATUS getStatus(){ return status; }
   
   public void setPosition(int x, int y){
       position.x = x;
       position.y = y;
   }
}
