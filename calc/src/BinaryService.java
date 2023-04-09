import java.util.HashMap;
import java.util.Map;

public class BinaryService {

    public static int fetchIntFromBinary(String binary) {
        return (int)Long.parseLong(binary, 2);
    }

    public static String toBinaryString(int i) {
        String binary = Integer.toBinaryString(i);
        while(binary.length() != 8) {
            binary = 0 + binary;
        }
        return binary;
    }

    public static String twoCharsRatio(char c1, char c2, int count1, int count2) {
        return charTimesN(c1, count1) + charTimesN(c2, count2);
    }

    public static String lastOne(int count) {
        return twoCharsRatio('0', '1', count - 1, 1);
    }

    public static String lastZero(int count) {
        return twoCharsRatio('1', '0', count - 1, 1);
    }

    public static String allOne(int count) {
        return charTimesN('1', count);
    }

    public static String allZero(int count) {
        return charTimesN('0', count);
    }

    private static String charTimesN(char c, int n) {
        String s = "";
        for(int i = 0; i < n; i++) {
            s += c;
        }
        return s;
    }

    public static String add(String binary, int count) {
        return Integer.toBinaryString(fetchIntFromBinary(binary) + count);
    }
}
