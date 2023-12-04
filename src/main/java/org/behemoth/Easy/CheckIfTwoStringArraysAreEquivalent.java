package org.behemoth.Easy;

public class CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {

    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Bas solution
        // The better idea is to use 2 pointers

        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();

        for (var w : word1) builder1.append(w);
        for (var w : word2) builder2.append(w);

        return builder1.compareTo(builder2) == 0;
    }
}
