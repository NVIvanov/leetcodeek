import java.util.Arrays;
import java.util.Comparator;

public class TrappingRainWater {

    public static int trap(int[] height) {
        var volume = 0;

        // Calculate maximum heights from the left
        int[] maxFromLeft = new int[height.length];
        maxFromLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxFromLeft[i] = Math.max(maxFromLeft[i - 1], height[i]);
        }

        // Calculate maximum heights from the right
        int[] maxFromRight = new int[height.length];
        maxFromRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(maxFromRight[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            volume += Math.min(maxFromLeft[i], maxFromRight[i]) - height[i];
        }
        return volume;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] {4,2,0,3,2,5}));
    }
}
