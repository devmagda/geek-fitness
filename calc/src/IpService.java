public class IpService {

    /**
     * Constructs an Ip from its Binary representation
     * 11111111111111111111111100000000 => 255.255.255.000
     * @param binary a binary representation of an IP address
     * @return a new Ip object of that binary representation
     */
    public static Ip fromBinaryString(String binary) {
        return new Ip(BinaryService.fetchIntFromBinary(binary.substring(0,8)),
                BinaryService.fetchIntFromBinary(binary.substring(8,16)),
                BinaryService.fetchIntFromBinary(binary.substring(16,24)),
                BinaryService.fetchIntFromBinary(binary.substring(24,32)));
    }

    /**
     * Converts an IP address to a binary representation
     * @param ip the IP address to convert
     * @return a binary representation
     */
    public static String toBinaryString(Ip ip) {
        return BinaryService.toEightDigitBinaryString(ip.ip[0])
                + BinaryService.toEightDigitBinaryString(ip.ip[1])
                + BinaryService.toEightDigitBinaryString(ip.ip[2])
                + BinaryService.toEightDigitBinaryString(ip.ip[3]);
    }

    /**
     * Creates the Broadcast Address from the given Cidr
     */
    public static Ip getBroadcastByCidr(int cidr) {
        String binary = BinaryService.twoCharsRatio('1', '0', cidr, 32-cidr);
        return fromBinaryString(binary);
    }


    /**
     * Calculates the first address in the network via binary representation
     * @param ip the ip to find the networkAddress of
     * @param cidr the given cidr
     * @return The network address of that IP
     */
    public static Ip getNetworkAddressByIpAndCidr(Ip ip, int cidr) {
        String binaryBase = toBinaryString(ip).substring(0, cidr);
        String binaryRest = BinaryService.allZero(32-cidr);
        return fromBinaryString(binaryBase + binaryRest);
    }

    /**
     * Calculates the last address in the network via binary representation (broadcast)
     * @param ip the ip to find the networkAddress of
     * @param cidr the given cidr
     * @return The network address of that IP
     */
    public static Ip getBroadcastByIpAndCidr(Ip ip, int cidr) {
        String binaryBase = toBinaryString(ip).substring(0, cidr);
        return fromBinaryString(binaryBase + BinaryService.allOne(32-cidr));
    }


    /**
     * Function to get the ip that is ip + count
     * @param ip the ip to increment
     * @param count addresses to skip
     * @return the ip that is ip + count
     */
    public static Ip increment(Ip ip, int count) {
        return fromBinaryString(BinaryService.add(toBinaryString(ip), count));
    }

    /**
     * Converts the number of wanted hosts to a cidr
     * @param count the number of hosts
     * @return the cidr
     */
    public static int getCidrFromAddressCount(int count) {
        return 32-Integer.toBinaryString(count+1).length();
    }
}
