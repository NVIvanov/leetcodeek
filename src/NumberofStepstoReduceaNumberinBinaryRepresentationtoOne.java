public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
    public static int numSteps(String s) {
        int count = 0;
        while (!s.equals("1")) {
            if (s.endsWith("0")) {
                s = s.substring(0, s.length() - 1);
            } else {
                int i = s.length() - 1;
                while (i >= 0 && s.charAt(i) == '1') {
                    i--;
                }
                StringBuilder sb = new StringBuilder();
                if (i >= 0) {
                    sb.append(s, 0, i);
                }
                sb.append("1");
                sb.append("0".repeat(s.length() - i - 1));
                s = sb.toString();
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSteps("1"));
    }
}
