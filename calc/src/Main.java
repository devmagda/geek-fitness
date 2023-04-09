import java.util.List;

public class Main {
    public static void main(String[] args) {

        Subnet net = NettingService.fromIpAndCidr(new Ip(192,168,1,10), 28);

        List<Subnet> nets = NettingService.split(net);

        nets.stream().forEach(s -> System.out.println(s.toString()));
    }
}