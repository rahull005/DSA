package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Pattern_5_MergeSort {
    private static void merge(int low, int mid, int high, int[] arr) {
        List<Integer> lst = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                lst.add(arr[left]);
                left++;
            } else {
                lst.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            lst.add(arr[left]);
            left++;
        }

        while (right <= high) {
            lst.add(arr[right]);
            right++;
        }

        for (int i = 0; i < lst.size(); i++) {
            arr[low + i] = lst.get(i);
        }
    }

    private static void mergeSort(int low, int high, int[] arr) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(low, mid, arr);
        mergeSort(mid + 1, high, arr);
        merge(low, mid, high, arr);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5};
        int n = arr.length;

        mergeSort(0, n - 1, arr);

        for (int x : arr) {
            System.out.println(x);
        }
    }
}
