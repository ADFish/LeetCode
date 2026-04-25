package round.leetcood75;

import java.util.Arrays;

public class Q1679 {
    public int maxOperations(int[] nums, int k) {
        int res = 0;
        int i = 0;
        int j = nums.length - 1;

        Arrays.sort(nums);

        while(i < j) {
            if (nums[i] + nums[j] == k) {
                res++;
                i++;
                j--;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
}
