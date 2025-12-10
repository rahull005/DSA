package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Pattern_7_CombinationsSum_2 {
    private static void CombinationSum_2(int ind, List<Integer> ds, int target, int[] arr, int n, List<List<Integer>> output) {
        if(target == 0){
            output.add(new ArrayList<>(ds));
            return;
        }

        for(int i = ind;i<arr.length;i++){
            if(i>ind && arr[i] == arr[i-1])continue;

            if(arr[i] > target) break;

            ds.add(arr[i]);
            CombinationSum_2(i+1,ds,target-arr[i],arr,n,output);
            ds.remove(ds.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,2,3,7};
        int n = arr.length;
        int target = 7;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        CombinationSum_2(0,ds,target,arr,n,output);
        System.out.println(output);
    }

}

/*
    The combination 2 is the combination of elements to reach the requied target but,
    here the output should not possess any duplicates.

    ⭐ FINAL TAKEAWAY: The Rule Explained
            if (i > idx && arr[i] == arr[i - 1]) continue;

            This means:
            ❌ Skip duplicates in the SAME recursion level
            (because they produce the same combination)
            ✔ Allow duplicates in deeper recursion levels
            (because they produce needed combinations like [1,1])

       The simple Observation helps in removing the duplicates that is,
       if we take the same element on the same recursion level it causes the duplicates,
       because, if we go deep down at recursion, we can find the same array that we present skip
       at the same recursion level

       Example:
                                         []
                   /          |            \
                  /           | (skip)       \
              pick 1       skip 1           pick 2
                |                            |
              [1]                          [2] → target=0 ✔
          /         \
      pick 1       pick 2
        |             |
     [1,1] ✔       [1,2] (invalid)


 */