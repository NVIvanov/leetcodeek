public class MakeTheStringGreat {

    public static String makeGood(String s) {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < s.length() - 1; i++) {
                if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
                    if (i > 0) {
                        s = s.substring(0, i) + s.substring(i + 2);
                    } else {
                        s = s.substring(i + 2);
                    }
                    changed = true;
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(makeGood("abBAcC"));
    }
}
