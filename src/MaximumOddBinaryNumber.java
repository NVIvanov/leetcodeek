public class MaximumOddBinaryNumber {

    public static String maximumOddBinaryNumber(String s) {
        byte ones = 0;
        for(byte i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        return "1".repeat(ones-1) + "0".repeat(s.length() - ones) + "1";
    }

    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("0101"));
    }
}
