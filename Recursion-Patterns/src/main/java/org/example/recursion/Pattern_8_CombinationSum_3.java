package org.example.recursion;
/*There is only use of numerals 1 through 9.
 A single use is made of each number.
Return list of every feasible combination that is allowed. The combinations can be returned in any order, but the list cannot have the same combination twice.

Example 1
Input : k = 3 , n = 7
Output : [ [1, 2, 4] ]
Explanation :
        1 + 2 + 4 = 7
There are no other valid combinations.

Example 2
Input : k = 3, n = 9
Output : [[1, 2, 6],[1, 3, 5],[2, 3, 4]]
Explanation :
        1 + 2 + 6 = 9
        1 + 3 + 5 = 9
        2 + 3 + 4 = 9
*/

import java.util.ArrayList;
import java.util.List;

public class Pattern_8_CombinationSum_3 {

    private static void CombinationSum_3(int start, List<Integer> ds, int target, int k, List<List<Integer>> output) {

        if (target == 0 && ds.size() == k) {
            output.add(new ArrayList<>(ds));
            return;
        }

        if (target < 0 || ds.size() > k) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            ds.add(i);
            CombinationSum_3(i + 1, ds, target - i, k, output);
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int target = 7;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();

        CombinationSum_3(1, ds, target, k, output); // start from 1
        System.out.println(output);
    }
}
