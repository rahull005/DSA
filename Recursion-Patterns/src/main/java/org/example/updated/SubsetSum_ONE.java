package org.example.updated;

/*
 * Problem: Given an integer array, find the sum of every possible subset.
 * Include the empty subset, whose sum is 0.
 *
 * Example:
 * Input array: [1, 2, 3]
 * Output: [6, 3, 4, 1, 5, 2, 3, 0]
 */


import java.util.ArrayList;

class SubsetSum_ONE {

    public void func(int idx, int sm, ArrayList<Integer> ans,
                     int[] nums, int n) {

        if (idx >= n) {
            ans.add(sm);
            return;
        }

        // Pick the current element
        func(idx + 1, sm + nums[idx], ans, nums, n);

        // Not pick the current element
        func(idx + 1, sm, ans, nums, n);
    }

    public ArrayList<Integer> subsetSums(int[] nums) {

        ArrayList<Integer> ans = new ArrayList<>();

        func(0, 0, ans, nums, nums.length);

        return ans;
    }
}