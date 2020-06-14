package binarySearch;

/**
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums.
 * If target exists, then return its index, otherwise return -1.
 *
 * @see <a href="https://leetcode.com/problems/binary-search/"> Origianl problem</>
 */

public class binarySearch {
    public static void main(String[] args) {
        int nums[] = {-1,0,3,5,9,12};
        int target = 2;
        System.out.println(search(nums, target));
    }

    private static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
