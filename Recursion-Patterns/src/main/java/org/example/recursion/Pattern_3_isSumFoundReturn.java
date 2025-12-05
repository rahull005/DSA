package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Pattern_3_isSumFoundReturn {
    private static boolean subsequencesSum(int i, List<Integer> ds, int sm, int target, int[] nums, int n) {
        if(i >= n){
            if(sm == target){
                return true;
            }else{
                return false;
            }
        }

        ds.add(nums[i]);
        sm += nums[i];
        if(subsequencesSum(i+1,ds,sm,target,nums,n)){
            return true;
        }

        sm -= ds.get(ds.size()-1);
        ds.remove(ds.size()-1);

        if(subsequencesSum(i+1,ds,sm,target,nums,n)){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,1};
        int n = arr.length;
        List<Integer> ds = new ArrayList<>();
        boolean isValid = subsequencesSum(0,ds,0,2,arr,n);
        System.out.println(isValid);
    }

}
