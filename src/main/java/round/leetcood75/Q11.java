package round.leetcood75;

public class Q11 {
    public int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;

        while(i < j) {
            if (height[i] <= height[j]) {
                res = Math.max(res, height[i] * (j - i));
                i++;
            } else {
                res = Math.max(res, height[j] * (j - i));
                j--;
            }
        }

        return res;
    }
}
