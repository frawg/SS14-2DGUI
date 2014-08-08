package Packets;

import Packets.IPPacket;

public class MACPacket {
    public int identification;
    public String srcMACAddress;
    public String destMACAddress;
    public IPPacket ipPacket;
    
    public MACPacket(){
        ipPacket = new IPPacket();
        identification = Globals.Globals.macPacketNumber++;
    }
}
