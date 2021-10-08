package ru.dataart.academy.java;

public class LongestSubstring {
    /**
     * @param checkString - input string to check
     * @return - length of max substring without repeatable characters
     * Example: dnmdncbb  -> 5 (mdncb)
     * amam -> 2 (am)
     */

    public int getLengthOfLongestSubstring(String checkString) {
        // Special cases check
        if (checkString.length() <= 1) return checkString.length();

        // main calculations
        String longestString = String.valueOf(checkString.charAt(0));
        String currentString = String.valueOf(checkString.charAt(0));
        int indexOfChar;
        for (int i = 1; i < checkString.length(); i++) {
            indexOfChar = currentString.indexOf(checkString.charAt(i));
            if (indexOfChar == -1) {
                currentString += String.valueOf(checkString.charAt(i));
                longestString = currentString;
            } else {
                currentString = currentString.substring(indexOfChar + 1) + String.valueOf(checkString.charAt(i));
            }
        }
        return longestString.length();
    }

}
