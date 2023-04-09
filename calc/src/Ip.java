/**
 * Ip class holding for integers:
 * 192.168.1.0 => ip[0].ip[1].ip[2].ip[3]
 */
public class Ip {
    public int[] ip;

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

    public boolean equals(Ip other) {
        return this.ip[0] == other.ip[0] && this.ip[1] == other.ip[1] && this.ip[2] == other.ip[2] && this.ip[3] == other.ip[3];
    }

    public String toString() {
        return ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3];
    }
}
