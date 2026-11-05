/*
 * Problem: Given distinct positive integers and a target, find all unique
 * combinations that sum to the target. Each number may be used any number
 * of times.
 *
 * Example input:
 * 4
 * 2 3 6 7
 * 7
 *
 * Example output:
 * [[2, 2, 3], [7]]
 */
package org.example.updated;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum_ONE {
    public static void func(int i, List<Integer> ds,
                            List<List<Integer>> ans,
                            int[] arr, int target, int n) {

        if (i == n) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (target < 0) {
            return;
        }

        // Include current element
        if (arr[i] <= target) {

            ds.add(arr[i]);

            // Stay at the same index because reuse is allowed
            func(i, ds, ans, arr, target - arr[i], n);

            // Backtrack
            ds.remove(ds.size() - 1);
        }

        // Exclude current element
        func(i + 1, ds, ans, arr, target, n);
    }

    public static List<List<Integer>> combinationSum(int[] candidates,
                                                      int target) {

        int n = candidates.length;

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        func(0, ds, ans, candidates, target, n);

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
        List<List<Integer>> ans = combinationSum(candidates, target);

        // Print result
        System.out.println(ans);

        sc.close();
    }
}


/*

        Input
4
2 3 6 7
7


Output
[[2, 2, 3], [7]]


Important recursion concept
func(i, ds, ans, arr, target - arr[i], n);


We use i instead of i + 1 because we can reuse the same element.

For example:
[2, 2, 2, 2]
[2, 2, 3]
[7]

*/