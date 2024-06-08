public class Atoi {

    public static int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        boolean headingSpacesStage = true;
        boolean signStage = false;
        boolean numStage = false;
        boolean negative = false;
        int result = 0;
        int prevResult;

        for (int i = 0; i < s.length(); i++) {
            if (headingSpacesStage) {
                if (s.charAt(i) == ' ') {
                    continue;
                } else {
                    headingSpacesStage = false;
                    signStage = true;
                }
            }

            if (signStage) {
                if (s.charAt(i) < '0') {
                    if (s.charAt(i) == '-') {
                        negative = true;
                        signStage = false;
                        i++;
                    } else if (s.charAt(i) == '+') {
                        signStage = false;
                        i++;
                    } else {
                        return 0;
                    }
                } else {
                    signStage = false;
                }
            }

            if (i >= s.length()) {
                return result;
            }
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return negative ? -result : result;
            }
            var d = Character.digit(s.charAt(i), 10);
            prevResult = result;
            result = prevResult * 10;
            if (result / 10 != prevResult) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            prevResult = result;
            result += d;
            if (result < prevResult) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(myAtoi("+"));
    }
}
