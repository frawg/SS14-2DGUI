package Globals;

import Globals.Globals;

public class Parser {
    
    static public int getIndexByID(Globals.Type type, int id){
        int index=0;
        if(type == Globals.Type.COMPUTER) {            
            for(int i=0; i < Globals.computerList.size(); i++){
                int currID = Globals.computerList.get(i).getID();
                if(id == currID){
                    index = i;
                    break;
                }
            }
        }
        else if(type == Globals.Type.HUB) {            
            for(int i=0; i < Globals.hubList.size(); i++){
                int currID = Globals.hubList.get(i).getID();
                if(id == currID){
                    index = i;
                    break;
                }
            }
        }
        
        else if(type == Globals.Type.SWITCH) {            
            for(int i=0; i < Globals.switchList.size(); i++){
                int currID = Globals.switchList.get(i).getID();
                if(id == currID){
                    index = i;
                    break;
                }
            }
        }
        else if(type == Globals.Type.ROUTER) {            
            for(int i=0; i < Globals.routerList.size(); i++){
                int currID = Globals.routerList.get(i).getID();
                if(id == currID){
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    
    static public int getIDByIndexAndType(Globals.Type type, int index){
        int returnIndex=0;
        if(type==Globals.Type.COMPUTER){
            returnIndex=Globals.computerList.get(index).getID();
        }
        
        else if(type==Globals.Type.HUB){
            returnIndex= Globals.hubList.get(index).getID();
        }
         
        else  if(type==Globals.Type.SWITCH){
            returnIndex= Globals.switchList.get(index).getID();
        }
          
        else if(type==Globals.Type.ROUTER){
            returnIndex= Globals.routerList.get(index).getID();
        }
            
      
        return index;
    }
    
    /* This method returns the type of the element on which the mouse is hovering */
    static public Element getSelectedElement(){
         Element e = new Element();
         for(int i=0; i < Globals.computerList.size(); i++){                
                if(Globals.computerList.get(i).isSelected() == Boolean.TRUE){                    
                    e.ID = Globals.computerList.get(i).getID();
                    e.index = i;
                    e.type = Globals.Type.COMPUTER;
                }
         }
         
         for(int i=0; i < Globals.hubList.size(); i++){                
                if(Globals.hubList.get(i).isSelected() == Boolean.TRUE){                    
                    e.ID = Globals.hubList.get(i).getID();
                    e.index = i;
                    e.type = Globals.Type.HUB;
                }
         }
         
         for(int i=0; i < Globals.switchList.size(); i++){                
                if(Globals.switchList.get(i).isSelected() == Boolean.TRUE){                    
                    e.ID = Globals.switchList.get(i).getID();
                    e.index = i;
                    e.type = Globals.Type.SWITCH;
                }
         }
         
         for(int i=0; i < Globals.routerList.size(); i++){                
                if(Globals.routerList.get(i).isSelected() == Boolean.TRUE){                    
                    e.ID = Globals.routerList.get(i).getID();
                    e.index = i;
                    e.type = Globals.Type.ROUTER;
                }
         }
         
         return e;
         
    }
    
     static public String getNextGlobalIPAddress(){
       String ip = "192.168.1."+Globals.GlobalIP;
       Globals.GlobalIP++;
       return ip;
    }
    static public String generateRandomMAC(){
        
       double r=0;
       String [] array = new String [12];
       for(int i=0; i < 12; i++){
           r = Math.random();
           if(r < 0.05) {array[i]="A";}
           else if(r < 0.08) {array[i]="B";}
           else if(r < 0.16) {array[i]="C";}
           else if(r < 0.24) {array[i]="D";}
           else if(r < 0.32) {array[i]="E";}
           else if(r < 0.40) {array[i]="F";}
           else if(r < 0.48) {array[i]="0";}
           else if(r < 0.56) {array[i]="1";}
           else if(r < 0.64) {array[i]="2";}
           else if(r < 0.72) {array[i]="3";}
           else if(r < 0.80) {array[i]="4";}
           else if(r < 0.88) {array[i]="5";}
           else {array[i]="8";}
           
       } 
       String mac = array[0]+array[1]+"-"+array[2]+array[3]+"-"+array[4]+array[5]+"-"+array[6]+
               array[7]+"-"+array[8]+array[9]+"-"+array[10]+array[11];
       return mac;
    } 
     
}
