import java.util.List;
import java.util.stream.Collectors;

public class Subnet {
    private Ip netAddress;
    private List<Ip> netSpace;
    private Ip broadcastAddress;
    private int cidr;

    private Subnet(Ip netAddress, List<Ip> netSpace, Ip broadcastAddress, int cidr) {
        this.netAddress = netAddress;
        this.netSpace = netSpace;
        this.broadcastAddress = broadcastAddress;
        this.cidr = cidr;
    }

    public Subnet() {
    }

    private String netSpaceToString() {
        return "{ " + netSpace.stream().map(i -> i.toString()).collect(Collectors.joining(" | ")) + " }";
    }

    public String toString() {
        String s = "Cidr: " + cidr + "\nNetworkAddress: " + netAddress + "\nBroadcast: " + broadcastAddress + "\nAddresses to be used: " + netSpaceToString();
        return s;
    }
    public Subnet(Ip netAddress) {
        this.netAddress = netAddress;
    }

    public void setCidr(int cidr) {
        this.cidr = cidr;
    }

    public void setNetAddress(Ip netAddress) {
        this.netAddress = netAddress;
    }

    public void setNetSpace(List<Ip> netSpace) {
        this.netSpace = netSpace;
    }

    public void setBroadcastAddress(Ip broadcastAddress) {
        this.broadcastAddress = broadcastAddress;
    }

    public Ip getNetAddress() {
        return netAddress;
    }

    public List<Ip> getNetSpace() {
        return netSpace;
    }

    public Ip getBroadcastAddress() {
        return broadcastAddress;
    }

    public int getCidr() {
        return cidr;
    }
}
