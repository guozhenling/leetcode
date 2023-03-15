package com.gzl.tesla;

import org.junit.Test;


public class BST {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int midV = nums[mid];
            if (midV < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    @Test
    public void test() {
        int[] nums = {4, 5, 6};
        System.out.println("findMin(nums) = " + findMin(nums));
        System.out.println("findMin(nums) = " + findMin2(nums));
    }


}
