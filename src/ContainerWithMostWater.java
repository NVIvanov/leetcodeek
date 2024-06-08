public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxVol = 0;
        while (l < r) {
            int vol = Math.min(height[l], height[r]) * (r - l);
            if (vol > maxVol) {
                maxVol = vol;
            }
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxVol;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));
    }
}
