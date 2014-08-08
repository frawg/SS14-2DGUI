package Packets;

public class IPPacket {
    public int identification;
    public int timeToLive;
    public int length;
    public String upperLayerProtocol;
    public String srcIPAddress;
    public String destIPAddress;
    public String data;
    
    public IPPacket(){
       identification = Globals.Globals.ipPacketNumber++;
       timeToLive = 30;
       length = 512;
       upperLayerProtocol = "UDP";
       data = "This is the data part of the IP Packet";
    }
}
