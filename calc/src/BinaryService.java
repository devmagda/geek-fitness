/**
 * Service for working with binary numbers.
 */
public class BinaryService {

    /**
     * Simple helper function to get the int value of a  binary number
     * @param binary String containing the binary number
     * @return int value of the binary number
     */
    public static int fetchIntFromBinary(String binary) {
        return (int)Long.parseLong(binary, 2);
    }

    /**
     *  Function to create an 8 Bit binary number from an integer
     * @param i Integer value
     * @return the converted binary number in 8 Bits (00000010 = 2)
     */
    public static String toEightDigitBinaryString(int i) {
        String binary = Integer.toBinaryString(i);
        while(binary.length() != 8) {
            binary = 0 + binary;
        }
        return binary;
    }

    /**
     * Helper function to reduce duplicated code. Can return two different chars like this:
     * "A", "B", 2, 3 => AABBB
     * "1", "0", 3, 5 => 11100000
     * Helpful for finding broadcast and other adresses
     * @param c1 first char
     * @param c2 second char
     * @param count1 count of first char
     * @param count2 count of second char
     * @return c1 * count1 + c2 * count2 (The generated string)
     */
    public static String twoCharsRatio(char c1, char c2, int count1, int count2) {
        return charTimesN(c1, count1) + charTimesN(c2, count2);
    }

    /**
     * Returning count number of digits of 0 but the last one as 1
     * (First usable Address)
     */
    public static String lastOne(int count) {
        return twoCharsRatio('0', '1', count - 1, 1);
    }

    /**
     * Returning count number of digits of 1 but the last one as 0
     * (Last usable Address)
     */
    public static String lastZero(int count) {
        return twoCharsRatio('1', '0', count - 1, 1);
    }

    /**
     * Returning count number of 1's
     * (broadcast)
     */
    public static String allOne(int count) {
        return charTimesN('1', count);
    }

    /**
     * Returning count number of 0's
     * (networkaddress)
     */
    public static String allZero(int count) {
        return charTimesN('0', count);
    }

    /**
     * Helper function for above
     */
    private static String charTimesN(char c, int n) {
        String s = "";
        for(int i = 0; i < n; i++) {
            s += c;
        }
        return s;
    }

    /**
     * Adds count to the binary representation of a number
     * @param binary the binary representation
     * @param count the count to add
     * @return the new binary String
     */
    public static String add(String binary, int count) {
        return Integer.toBinaryString(fetchIntFromBinary(binary) + count);
    }
}
