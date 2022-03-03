package dailyPractice.jianzhi;

public class Q3 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int result = findRepeatNumber(nums);
        System.out.println(result);

    }

    public static int findRepeatNumber(int[] nums) {
        int[] resultArray = new int[nums.length];
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            resultArray[num] += 1;
        }

        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] > 1) {
                result = i;
                break;
            }
        }
        return result;
    }

}
