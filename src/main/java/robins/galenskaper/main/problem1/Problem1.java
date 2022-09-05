package robins.galenskaper.main.problem1;

import java.util.Arrays;

import static robins.galenskaper.main.Main.takeInput;

public class Problem1 {

    public static boolean isAnagram(String str1, String str2){
        //Using my input method to take both strings, making all of it lowercase as to avoid case sensitivity
        String anagram1 = str1.toLowerCase();
        String anagram2 = str2.toLowerCase();

        //Using my stringSorter method to actually sort the strings so that we can compare them
        anagram1 = stringSorter(anagram1);
        anagram2 = stringSorter(anagram2);

        //Returning results
        return anagram1.equals(anagram2);
    }

    //Method to alphabetically sort a given string
    private static String stringSorter(String sortThis){
        //Creating an array of characters to be sorted
        char[] tempArray =  sortThis.toCharArray();

        //Sorting the array
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

}