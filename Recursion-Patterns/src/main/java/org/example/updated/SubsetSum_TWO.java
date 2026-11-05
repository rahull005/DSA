/*
 * Problem: Given an integer array that may contain duplicates, return every
 * distinct subset. The empty subset is included, and the result must not
 * contain duplicate subsets.
 *
 * Example input:
 * 3
 * 1 2 2
 *
 * Example output:
 * [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
 */
package org.example.updated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubsetSum_TWO {
    public static void func(int idx, List<Integer> ds,
                            List<List<Integer>> ans,
                            int[] nums, int n) {

        // Base case: store current subset
        ans.add(new ArrayList<>(ds));

        for (int i = idx; i < n; i++) {

            // Skip duplicates
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            // Pick
            ds.add(nums[i]);

            // Recursive call
            func(i + 1, ds, ans, nums, n);

            // Backtrack
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        func(0, ds, ans, nums, nums.length);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        // Read array elements
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call function
        List<List<Integer>> result = subsetsWithDup(nums);

        // Print result
        System.out.println(result);

        sc.close();
    }
}
