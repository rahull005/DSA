package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Pattern_0_GenerateSubsequences {
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        int n = 3;
        List<Integer> ds = new ArrayList<>();
        subsequences(0,ds,arr,n);
    }

    private static void subsequences(int i, List<Integer> ds, int[] arr, int n) {
        if(i >= n){
            System.out.println(ds);
            return;
        }

        ds.add(arr[i]);
        subsequences(i+1,ds,arr,n);
        ds.remove(ds.size()-1);
        subsequences(i+1,ds,arr,n);
    }
}
