package binarySearch;

// https://leetcode.com/problems/find-peak-element/

public class findPeakElement {

    public static void main(String[] args) {
        int nums[] = {1, 2};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return start;
        } else {
            return end;
        }

    }
}
