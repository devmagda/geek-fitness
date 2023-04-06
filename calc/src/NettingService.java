import java.util.ArrayList;
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

    public static Ip getBroadcastByCidr(int cidr) {
        String binary = charTimesN('1', cidr) + charTimesN('1', 32-cidr);
        return new Ip()
    }
    private static String charTimesN(char c, int n) {
        String s = "";
        for(int i = 0; i < n; i++) {
            s += c;
        }
        return s;
    }
}
