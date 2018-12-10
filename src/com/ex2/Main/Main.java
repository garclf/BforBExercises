package com.ex2.Main;

import com.ex2.Main.Utils.WordHandler;

public class Main {

    public static void main(String[] args) {
        final String[] WORDS = {"vase","bat","gods","latte","name",
                "apres","spit","joke","ham","dog","act","tale","parse",
                "pits","asper","tab","table","mane","late","god","cat",
                "table","save","spare"};

        WordHandler wHandler = WordHandler.getInstance();

        for(String eachWord: WORDS) {
            wHandler.getAnagram(eachWord, WORDS);
        }
    }
}
