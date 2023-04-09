import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Subnet net = NettingService.fromIpAndCidr(new Ip(192,168,1,2), 24);
        System.out.println("## Base network ##\n" + net.toString());

        Subnet netHostCount = NettingService.fromSubnetAndHostCount(net, 24);
        System.out.println("## Host Count (24) network ##\n" + netHostCount.toString());
    }
}