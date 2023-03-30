import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NettingService {
    public static Map<String, Integer> binaryMap = new HashMap<>();

    public static void load() {
        for(int i = 0; i < 256; i++) {
            binaryMap.put(Integer.toBinaryString(i), i);
        }
    }

    private static int fetchIntFromBinary(String binary) {
        return binaryMap.get(binary);
    }

    public static Subnet getBy(Ip address, Ip netAddress, Ip broadcastAddress) {
        Subnet net = new Subnet();

        return net;
    }
}
