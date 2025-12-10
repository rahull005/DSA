package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Pattern_6_CombinationsSum_1 {
    private static void CombinationSum(int i, List<Integer> ds, int target, int[] arr, int n, List<List<Integer>> output) {
        if(i == n){
            if(target == 0){
                output.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[i] <= target){
            ds.add(arr[i]);
            CombinationSum(i,ds,target-arr[i],arr,n,output);
            ds.remove(ds.size()-1);
        }

        CombinationSum(i+1,ds,target,arr,n,output);
    }
    public static void main(String[] args) {
        int[] arr = {2,3,5,7};
        int n = arr.length;
        int target = 7;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        CombinationSum(0,ds,target,arr,n,output);
        System.out.println(output);
    }

}


/*
    The main aim of the combination sum we can add the same indexed element to achieve the target sum
 */