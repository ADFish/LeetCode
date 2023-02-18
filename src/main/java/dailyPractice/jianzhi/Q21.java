package dailyPractice.jianzhi;

public class Q21 {
    public static void main(String[] args) {
        Q21 test = new Q21();
        int[] nums = {1, 2, 3, 4};
        int [] res = test.exchange(nums);
        for (int i = 0; i < res.length ; i++) {
            System.out.print(res[i] + ",");
        }
    }

    public int[] exchange(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] % 2 == 0) {
                res[j] = nums[k];
                j--;
            } else {
                res[i] = nums[k];
                i++;
            }
        }
        return res;
    }
}
