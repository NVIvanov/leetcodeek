import java.util.Arrays;

public class BoatstoSavePeople {

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.parallelSort(people);
        int l = 0, r = people.length - 1;
        int count = 0;
        while (l < r) {
            if (people[l] + people[r] <= limit) {
                count++;
                l++;
                r--;
            } else {
                count++;
                r--;
            }
        }
        if (l == r) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3,5,3,4}, 5));
    }
}
