package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Pattern_1_GenerateSubsequencesToOutput {
    private static void subsequences(int i, List<Integer> ds, int[] arr, int n, List<List<Integer>> output) {
        if(i >= n){
            output.add(new ArrayList<>(ds));
            return;
        }

        ds.add(arr[i]);
        subsequences(i+1,ds,arr,n,output);
        ds.remove(ds.size()-1);
        subsequences(i+1,ds,arr,n,output);
    }


    public static void main(String[] args) {
        int[] arr = {3,1,2};
        int n = 3;
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        subsequences(0,ds,arr,n,output);
        System.out.println(output);
    }
}
