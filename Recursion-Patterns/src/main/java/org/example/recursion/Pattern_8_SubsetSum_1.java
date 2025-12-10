package org.example.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pattern_8_SubsetSum_1 {
    private static void SubsetSum1(int i, int sm, int[] arr, int n, List<Integer> output) {
        if(i == n){
            output.add(sm);
            return;
        }

        SubsetSum1(i+1,sm+arr[i],arr,n,output);
        SubsetSum1(i+1,sm,arr,n,output);
    }
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        int n = arr.length;
        List<Integer> output = new ArrayList<>();
        SubsetSum1(0,0,arr,n,output);
//        Collections.sort(output);
        System.out.println(output);
    }

}
