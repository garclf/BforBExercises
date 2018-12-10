package com.ex2.Main.Utils;

import java.util.Arrays;
import java.util.Comparator;

public class WordHandler {

    public static WordHandler wordHandler;

    public static WordHandler getInstance() {
        if(wordHandler == null) {
            wordHandler = new WordHandler();
        }

        return wordHandler;
    }

    public void getAnagram(String toCheck, String[] words) {
        char[] w1 = toCheck.toCharArray();

        //Arrays.sort(words, Comparator.comparing(String::length));

        for(String comp: words) {
            char[] tmp1 = comp.toCharArray();

            if(w1.length == tmp1.length && !toCheck.equals(comp)) {
                //System.out.println(new String (w1) + " same length as: " + new String(comp));

                Arrays.sort(w1);
                Arrays.sort(tmp1);

                if(Arrays.equals(w1, tmp1)){
                    System.out.println(toCheck + " is anagram of " + new String(comp));
                    continue;
                }

            }
        }
    }

}
