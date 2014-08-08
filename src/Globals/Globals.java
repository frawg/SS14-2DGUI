package Globals;

import Nodes.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class Globals {
    
    public enum Type { COMPUTER, SWITCH, HUB, ROUTER, LINK };
    public enum STATUS { UP, DOWN, DELETED };   
    public static ArrayList<COMPUTER> computerList;    
    public static ArrayList<HUB> hubList;   
    public static ArrayList<SWITCH> switchList;   
    public static ArrayList<ROUTER> routerList;  
    public static ArrayList<LINK> linkList; 
    public static int pcCounter = 0;
    public static int hubCounter = 0;
    public static int switchCounter = 0;
    public static int routerCounter = 0;
    public static int linkCounter = 0;
    public static int GlobalIP = 1;
    public static int numbSwitchPorts = 16;
    public static int ipPacketNumber = 0;
    public static int macPacketNumber = 0;
    public static Type lastSelectedType;
}
