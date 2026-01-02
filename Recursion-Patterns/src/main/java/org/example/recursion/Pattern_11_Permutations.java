package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Pattern_11_Permutations {
    private static void generatePermuation(List<Integer> ds, List<List<Integer>> output, int[] arr, boolean[] check, int n) {
        if(ds.size() == n){
            output.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<n;i++){
            if(check[i]) continue;

            check[i] = true;
            ds.add(arr[i]);
            generatePermuation(ds,output,arr,check,n);
            check[i] = false;
            ds.remove(ds.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        boolean[] check = new boolean[arr.length];
        generatePermuation(ds,output,arr,check,n);
        System.out.println(output);
    }

}
