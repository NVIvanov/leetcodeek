public class MinimumLengthofStringAfterDeletingSimilarEnds {

    public static int minimumLength(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char c = s.charAt(l);
            if (s.charAt(r) != c) {
                return r - l + 1;
            }
            while (l < r && (s.charAt(++l)) == c);
            while ((s.charAt(--r)) == c && l < r);
        }
        return r - l + 1;
    }

    public static void main(String[] args) {
        System.out.println(minimumLength("aabccabba"));
    }
}
