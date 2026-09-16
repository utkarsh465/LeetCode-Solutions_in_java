class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency of every character
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int maxVowel = 0;
        int maxConsonant = 0;

        // Step 2: Find maximum frequency
        for (char ch : map.keySet()) {

            int frequency = map.get(ch);

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {

                maxVowel = Math.max(maxVowel, frequency);

            } else {

                maxConsonant = Math.max(maxConsonant, frequency);
            }
        }

        // Step 3: Return maximum vowel + maximum consonant
        return maxVowel + maxConsonant;
    }
}