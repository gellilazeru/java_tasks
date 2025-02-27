import java.util.HashMap;

public class letter_count {
    public static void main(String[] args) {
        // Test cases
        System.out.println(LetterCount("hello Apple pie"));  // Expected: hello
        System.out.println(LetterCount("Today, is the greatest day ever!"));  // Expected: greatest
        System.out.println(LetterCount("no repeated letters here"));  // Expected: -1
    }

    public static String LetterCount(String str) {
        String[] words = str.split("\\s+");  // Split string into words

        // Iterate through each word
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");  // Remove non-alphabet characters

            if (word.length() == 0) continue;  // Skip empty words after cleaning

            HashMap<Character, Integer> letterCount = new HashMap<>();

            // Count the frequency of each character in the word
            for (char c : word.toCharArray()) {
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }

            // Check if there are any repeated letters (i.e., letters that appear more than once)
            for (int count : letterCount.values()) {
                if (count > 1) {
                    return word;  // Return the first word that has repeated letters
                }
            }
        }

        return "-1";  // Return -1 if no word with repeated letters is found
    }
}
