import java.util.Arrays;

public class MaximizeHappinessofSelectedChildren {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        for (int i = happiness.length - 1; i > happiness.length - 1 - k; i--) {
            sum += Math.max(0, happiness[i] - (happiness.length - 1 - i));
            System.out.println(sum);
        }
        return sum;
    }
}
