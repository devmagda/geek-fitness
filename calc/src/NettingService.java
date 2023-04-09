import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NettingService {

    public static Subnet fromIpAndCidr(Ip ip, int cidr) {
        Subnet net = new Subnet();
        net.setCidr(cidr);
        net.setNetAddress(IpService.getNetworkAddressByIpAndCidr(ip, cidr));
        net.setBroadcastAddress(IpService.getBroadcastByIpAndCidr(ip, cidr));
        net.setNetSpace(getUsableIps(net));
        return net;
    }

    public static Subnet generateNext(Subnet net) {
        Ip broadcast = net.getBroadcastAddress();
        Ip next = IpService.increment(broadcast, 1);
        return fromIpAndCidr(next, net.getCidr());
    }

    public static List<Subnet> split(Subnet net) {
        List<Subnet> nets = new ArrayList<>();
        Ip networkAddress = net.getNetAddress();
        Subnet net1 = fromIpAndCidr(networkAddress, net.getCidr() + 1);
        Subnet net2 = generateNext(net1);
        nets.add(net1);
        nets.add(net2);
        return nets;
    }

    private static List<Ip> getUsableIps(Subnet net) {
        List<Ip> ips = new ArrayList<>();
        Ip i = IpService.increment(net.getNetAddress(), 1);
        while(!i.equals(net.getBroadcastAddress())) {
            ips.add(i);
            i = IpService.increment(i, 1);
        }
        return ips;
    }
}
