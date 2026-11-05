/*
 * Problem: Given positive integers that may contain duplicates, find all
 * unique combinations that sum to the target. Each array element may be used
 * at most once, even when its value appears more than once.
 *
 * Example input:
 * 7
 * 10 1 2 7 6 1 5
 * 8
 *
 * Example output:
 * [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
 */
package org.example.updated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSum_two {
    public static void func(int ind, List<Integer> ds,
                            List<List<Integer>> ans,
                            int[] nums, int target, int n) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < n; i++) {

            // Skip duplicate elements at the same recursion level
            if (i > ind && nums[i - 1] == nums[i]) {
                continue;
            }

            // Since array is sorted, no need to check further
            if (nums[i] > target) {
                break;
            }

            // Pick
            ds.add(nums[i]);

            // Move to next index because reuse is not allowed
            func(i + 1, ds, ans, nums, target - nums[i], n);

            // Backtrack
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates,
                                                       int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        func(0, ds.get(0), ans, candidates, target, candidates.length);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();

        // Input array
        int[] candidates = new int[n];

        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        // Input target
        int target = sc.nextInt();

        // Function call
        List<List<Integer>> ans = combinationSum2(candidates, target);

        // Print result
        System.out.println(ans);

        sc.close();
    }
}


/*

Input
7
10 1 2 7 6 1 5
8


Output
[[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]

*/