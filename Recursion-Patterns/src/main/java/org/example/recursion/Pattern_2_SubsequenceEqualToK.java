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


        /*

            ->Sent by pass by value i.e we are not modifying the sum values in sm variable we are just,
              changing the value and calling the function by assigning new value and the parent remains same.

            -> as we see the above code we are modifying the value in the sm variable so later we need to
                subtract the same value from the sm,
                but in the below code , a new sm value created and function called and no change in the parent value
                we return to the parent the value remains same.



                ds.add(arr[i]);
                subsequencesSm(i+1,ds,sm+arr[i],k,arr,n,output);
                ds.remove(ds.size()-1);
                subsequencesSm(i+1,ds,sm,k,arr,n,output);
         */

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
