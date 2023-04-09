import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NettingService {

    /**
     * Creates a Subnet from an Ip and a Cidr
     * @param ip the Ip
     * @param cidr the Cidr
     * @return the Subnet
     */
    public static Subnet fromIpAndCidr(Ip ip, int cidr) {
        Subnet net = new Subnet();
        net.setCidr(cidr);
        net.setNetAddress(IpService.getNetworkAddressByIpAndCidr(ip, cidr));
        net.setBroadcastAddress(IpService.getBroadcastByIpAndCidr(ip, cidr));
        net.setNetSpace(getUsableIps(net));
        return net;
    }

    /**
     * Creates a Subnet from an already existing Subnet and a Cidr
     * @param net the subnet to create another subnet from
     * @param cidr the cidr
     * @return the new Subnet
     * @throws Exception Throws error if the subnet to be created is bigger then the already existing one
     */
    public static Subnet fromSubnetAndCidr(Subnet net, int cidr) throws Exception {
        if(cidr < net.getCidr()) {
            throw new Exception("Cant create a subnet that is bigger than this subnet!");
        }
        /*
        Choosing NetAddress here splits the network address at front
        Using BroadcastAddress would split it at the end which is more helpful and gives us more space to use
         */
        return fromIpAndCidr(net.getBroadcastAddress(), cidr);
    }

    /**
     * Creates a Subnet from an already existing Subnet and an amount of hosts needed
     * @param net the subnet to create another subnet from
     * @param hostCount the amount of hosts needed
     * @return the new Subnet
     * @throws Exception Throws error if the subnet to be created is bigger then the already existing one
     */
    public static Subnet fromSubnetAndHostCount(Subnet net, int hostCount) throws Exception {
        return fromSubnetAndCidr(net, IpService.getCidrFromAddressCount(hostCount));
    }

    /**
     * Creates a Subnet from an Ip and the number of hosts needed in the subnet
     * @param ip the Ip
     * @param hostCount the number of hosts
     * @return the Subnet
     */
    public static Subnet fromIpAndHostCount(Ip ip, int hostCount) {
        return fromIpAndCidr(ip, IpService.getCidrFromAddressCount(hostCount));
    }

    /**
     * Function to create the next available Subnet from another one
     * @param net the Subnet to increment
     * @return the next Subnet
     */
    public static Subnet generateNext(Subnet net) {
        Ip broadcast = net.getBroadcastAddress();
        Ip next = IpService.increment(broadcast, 1);
        return fromIpAndCidr(next, net.getCidr());
    }

    /**
     * Splits up a Subnet into the next two smaller subnets
     * @param net the bigger subnet
     * @return a List of two smaller Subnets
     */
    public static List<Subnet> split(Subnet net) {
        List<Subnet> nets = new ArrayList<>();
        Ip networkAddress = net.getNetAddress();
        Subnet net1 = fromIpAndCidr(networkAddress, net.getCidr() + 1);
        Subnet net2 = generateNext(net1);
        nets.add(net1);
        nets.add(net2);
        return nets;
    }

    /**
     * Creates a list of usable Ips in the Subnet (Netaddress+1 -> broadcast-1)
     * @param net the subnet
     * @return the List of usable Ips
     */
    private static List<Subnet> getUsableIps(Subnet net) {
        List<Subnet> ips = new ArrayList<>();
        Ip i = IpService.increment(net.getNetAddress(), 1);
        while(!i.equals(net.getBroadcastAddress())) {
            ips.add(new Subnet(i));
            i = IpService.increment(i, 1);
        }
        return ips;
    }
}
