public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] version1parts = version1.split("\\.");
        String[] version2parts = version2.split("\\.");
        for (int i = 0; i < Math.max(version1parts.length, version2parts.length); i++) {
            if (Integer.parseInt(elementOrZero(version1parts, i)) > Integer.parseInt(elementOrZero(version2parts, i))) {
                return 1;
            } else if (Integer.parseInt(elementOrZero(version1parts, i)) < Integer.parseInt(elementOrZero(version2parts, i))) {
                return -1;
            }
        }
        return 0;
    }

    private static String elementOrZero(String[] array, int index) {
        if (index < array.length) {
            return array[index];
        }
        return "0";
    }

    public static void main(String[] args) {

    }
}
