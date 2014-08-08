package Nodes;

public class HUB {
   private int id;
   private boolean isSelected;
   private String macAddress;
   private String guiID = "HUB"+this.id;
   private enum STATUS { UP, DOWN, DELETED };
   private STATUS status;

   public HUB(int id)
   {
       status = STATUS.UP;
       this.id = id;
       macAddress = Globals.Parser.generateRandomMAC();
       
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
   
   public String getMACAddress(){
        return macAddress;
    }
   public String getguiID(){ return guiID; }
   public STATUS getStatus(){
       return status;
   }
}
