public class IpService {
    public static int getDistance(Ip ipA, Ip ipB) {
        return 0;
    }

    public static Ip fromBinaryString(String binary) {
        return new Ip(BinaryService.fetchIntFromBinary(binary.substring(0,8)),
                BinaryService.fetchIntFromBinary(binary.substring(8,16)),
                BinaryService.fetchIntFromBinary(binary.substring(16,24)),
                BinaryService.fetchIntFromBinary(binary.substring(24,32)));
    }

    public static String toBinaryString(Ip ip) {
        return BinaryService.toBinaryString(ip.ip[0])
                + BinaryService.toBinaryString(ip.ip[1])
                + BinaryService.toBinaryString(ip.ip[2])
                + BinaryService.toBinaryString(ip.ip[3]);
    }

    public static Ip getBroadcastByCidr(int cidr) {
        String binary = BinaryService.twoCharsRatio('1', '0', cidr, 32-cidr);
        return fromBinaryString(binary);
    }



    public static Ip getNetworkAddressByIpAndCidr(Ip ip, int cidr) {
        String binaryBase = toBinaryString(ip).substring(0, cidr);
        String binaryRest = BinaryService.allZero(32-cidr);
        return fromBinaryString(binaryBase + binaryRest);
    }

    public static Ip getBroadcastByIpAndCidr(Ip ip, int cidr) {
        String binaryBase = toBinaryString(ip).substring(0, cidr);
        return fromBinaryString(binaryBase + BinaryService.allOne(32-cidr));
    }

    public static Ip increment(Ip ip, int count) {
        return fromBinaryString(BinaryService.add(toBinaryString(ip), count));
    }
}
