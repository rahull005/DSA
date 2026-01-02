package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

/*
    Given a string consisting of digits from 2 to 9 (inclusive). Return all possible letter combinations that the number can represent.
    Mapping of digits to letters is given in first example.

    Example 1
    Input : digits = "34"
    Output : [ "dg", "dh", "di", "eg", "eh", "ei", "fg", "fh", "fi" ]

    Explanation : The 3 is mapped with "def" and 4 is mapped with "ghi".
    So all possible combination by replacing the digits with characters are shown in output.
 */
public class Pattern_12_LetterPhoneNumberCombination {
    private static String[] map;
    public Pattern_12_LetterPhoneNumberCombination(){
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }
    private static void func(String digits, List<String> output, String string, int idx, int n) {
        if(idx == digits.length()){
            output.add(string);
            return;
        }
        String str = map[digits.charAt(idx)-'0'];
        for(int i=0;i<str.length();i++){
            func(digits,output,string+str.charAt(i),idx+1,n);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if (digits.isEmpty()) return output;
        func(digits,output,"",0,digits.length());
        return output;
    }
    public static void main(String[] args) {
        Pattern_12_LetterPhoneNumberCombination solution = new Pattern_12_LetterPhoneNumberCombination();
        String digits = "34"; // Input digits
        List<String> result = solution.letterCombinations(digits);

        for (String combination : result) {
            System.out.print(combination + " ");
        }

    }

}
