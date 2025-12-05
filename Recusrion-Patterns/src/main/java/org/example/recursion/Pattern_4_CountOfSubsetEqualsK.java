package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Pattern_4_CountOfSubsetEqualsK {
    private static int subsequencesSumCount(int i, List<Integer> ds, int sm, int target, int[] arr, int n) {
        if(i >= n){
            if(sm == target){
                return 1;
            }else{
                return 0;
            }
        }

        sm += arr[i];
        ds.add(arr[i]);
        int taken = subsequencesSumCount(i+1,ds,sm,target,arr,n);
        sm -= ds.get(ds.size()-1);
        ds.remove(ds.size()-1);
        int notTaken = subsequencesSumCount(i+1,ds,sm,target,arr,n);
        return taken+notTaken;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,1};
        int n = arr.length;
        List<Integer> ds = new ArrayList<>();
        int count = subsequencesSumCount(0,ds,0,2,arr,n);
        System.out.println(count);
    }
}
