package org.example.recursion;

import java.util.ArrayList;
import java.util.List;
/*
        the main aim of this problem is we have to print all the possible subsets
        without repeating.
 */
public class Pattern_9_SubsetSum_2 {
    private static void SubsetSum2(int ind,  int[] arr, int n, List<Integer> ds, List<List<Integer>> output) {
        output.add(new ArrayList<>(ds));

        for(int i=ind;i<n;i++){
            if(i > ind && arr[i] == arr[i-1])continue;

            ds.add(arr[i]);
            SubsetSum2(i+1,arr,n,ds,output);
            ds.remove(ds.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        int n = arr.length;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        SubsetSum2(0,arr,n,ds,output);
        System.out.println(output);
    }

    /*
            why not base condition ?
            -> here if we pass the base condition, think that the empty ds will not pass
                in that ans, still if you want to use the base case, you can add empty ds to ans externally


      example :
        private static void SubsetSum2(int ind,  int[] arr, int n, List<Integer> ds, List<List<Integer>> output) {

            if(i>=n){
                output.add(new ArrayList<>(ds));
                return;
            }

            for(int i=ind;i<n;i++){
                if(i > ind && arr[i] == arr[i-1])continue;

                ds.add(arr[i]);
                SubsetSum2(i+1,arr,n,ds,output);
                ds.remove(ds.size()-1);
            }
        }

        public static void main(String[] args) {
            int[] arr = {1,2,2};
            int n = arr.length;
            List<Integer> ds = new ArrayList<>();
            List<List<Integer>> output = new ArrayList<>();
            output.add(ds);   -------------------------------------->>>>>>> here we see we added empty ds externally
            SubsetSum2(0,arr,n,ds,output);
            System.out.println(output);
        }
     */

}
