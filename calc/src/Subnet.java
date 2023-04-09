import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the Subnet Class holding all information about the Subnet
 */
public class Subnet {
    /**
     * The Network Address
     */
    private Ip netAddress;
    /**
     * The list of usable IP's in the Subnet
     */
    private List<Subnet> netSpace;
    /**
     * The Broadcast Address
     */
    private Ip broadcastAddress;
    /**
     * The CIDR
     */
    private int cidr;

    private Subnet(Ip netAddress, List<Subnet> netSpace, Ip broadcastAddress, int cidr) {
        this.netAddress = netAddress;
        this.netSpace = netSpace;
        this.broadcastAddress = broadcastAddress;
        this.cidr = cidr;
    }

    public Subnet() {
    }

    private String netSpaceToString() {
        return "{ " + netSpace.stream().map(s -> s.getNetAddress().toString()).collect(Collectors.joining(" | ")) + " }";
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

    public void setNetSpace(List<Subnet> netSpace) {
        this.netSpace = netSpace;
    }

    public void setBroadcastAddress(Ip broadcastAddress) {
        this.broadcastAddress = broadcastAddress;
    }

    public Ip getNetAddress() {
        return netAddress;
    }

    public List<Subnet> getNetSpace() {
        return netSpace;
    }

    public Ip getBroadcastAddress() {
        return broadcastAddress;
    }

    public int getCidr() {
        return cidr;
    }
}
