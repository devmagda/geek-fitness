public class Ip {
    private int[] ip;

    public Ip(int a, int b, int c, int d) {
        this.ip = new int[4];
        ip[0] = a;
        ip[1] = b;
        ip[2] = c;
        ip[3] = d;
    }

    public Ip(int[] ip) {
        this.ip = ip;
    }

    public String toString() {
        return ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3];
    }
}
