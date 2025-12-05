package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Pattern_2_SubsequenceEqualToK {
    private static void subsequencesSm(int i, List<Integer> ds, int sm, int k, int[] arr, int n, List<List<Integer>> output) {
        if(i == n){
            if(sm == k){
                output.add(new ArrayList<>(ds));
            }
            return;
        }

        ds.add(arr[i]);
        sm += arr[i];
        subsequencesSm(i+1,ds,sm,k,arr,n,output);
        sm -= ds.get(ds.size()-1);
        ds.remove(ds.size()-1);
        subsequencesSm(i+1,ds,sm,k,arr,n,output);

    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,1};
        int n = arr.length;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        subsequencesSm(0,ds,0,2,arr,n,output);
        System.out.println(output);
    }
}
