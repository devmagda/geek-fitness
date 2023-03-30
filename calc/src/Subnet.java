import java.util.List;

public class Subnet {
    private Ip netAddress;
    private List<Subnet> netSpace;
    private Ip broadcastAddress;
    private int cidr;

    private Subnet(Ip netAddress, List<Subnet> netSpace, Ip broadcastAddress, int cidr) {
        this.netAddress = netAddress;
        this.netSpace = netSpace;
        this.broadcastAddress = broadcastAddress;
        this.cidr = cidr;
    }

    public Subnet() {
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
}
