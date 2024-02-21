package byt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutoAnagramSolver {

    public static boolean isValid(String word, String candidate) {
        /**
         * Checks if the candidate word is a valid permutation of the given word.
         */
        char[] wordArray = word.toCharArray();
        char[] candidateArray = candidate.toCharArray();
        Arrays.sort(wordArray);
        Arrays.sort(candidateArray);
        return Arrays.equals(wordArray, candidateArray);
    }

    public static void solveAnagram(String word, String candidate, List<String> result) {
        /**
         * Recursively solves the anagram puzzle using backtracking.
         */
        if (candidate.length() == word.length()) {
            result.add(candidate);
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            if (candidate.indexOf(word.charAt(i)) == -1) {
                solveAnagram(word, candidate + word.charAt(i), result);
            }
        }
    }

    public static List<String> autoAnagram(String inputLetters) {
        /**
         * Solves the word jumble puzzle given a set of jumbled letters.
         */
        List<String> result = new ArrayList<>();
        solveAnagram(inputLetters, "", result);
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        String jumbledLetters = "etars";
        List<String> solutions = autoAnagram(jumbledLetters);
        System.out.println("Solutions: " + solutions);
    }
}
