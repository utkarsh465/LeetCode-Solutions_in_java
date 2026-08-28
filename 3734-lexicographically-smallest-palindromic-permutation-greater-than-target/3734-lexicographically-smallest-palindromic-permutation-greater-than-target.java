class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Count characters
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // More than one odd frequency -> palindrome impossible
        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        // Only half of each character is needed for the left half
        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }

        int half = n / 2;

        char[] ans = new char[n];

        // Try to make the left half equal to target
        int pos = 0;

        while (pos < half) {

            int ch = target.charAt(pos) - 'a';

            if (freq[ch] == 0) {
                break;
            }

            ans[pos] = target.charAt(pos);
            freq[ch]--;

            pos++;
        }

        // If we successfully matched the complete left half,
        // construct palindrome and check whether it is > target.
        if (pos == half) {

            buildPalindrome(ans, half, middle);

            String result = new String(ans);

            if (result.compareTo(target) > 0) {
                return result;
            }
        }

        // Now we need to make the palindrome bigger.
        while (true) {

            // Try to increase the current position
            if (pos < half) {

                int start = target.charAt(pos) - 'a' + 1;

                for (int ch = start; ch < 26; ch++) {

                    if (freq[ch] > 0) {

                        ans[pos] = (char) ('a' + ch);
                        freq[ch]--;

                        // Fill remaining positions with
                        // smallest possible characters
                        int index = pos + 1;

                        for (int c = 0; c < 26; c++) {
                            while (freq[c] > 0) {
                                ans[index++] = (char) ('a' + c);
                                freq[c]--;
                            }
                        }

                        // Build palindrome
                        buildPalindrome(ans, half, middle);

                        return new String(ans);
                    }
                }
            }

            // We couldn't increase at this position.
            // Move backward and restore the character.
            if (pos == 0) {
                return "";
            }

            pos--;

            int oldChar = target.charAt(pos) - 'a';

            freq[oldChar]++;
        }
    }

    private void buildPalindrome(char[] ans, int half, int middle) {

        int n = ans.length;

        // Middle character for odd length
        if (n % 2 == 1) {
            ans[half] = (char) ('a' + middle);
        }

        // Mirror left half
        for (int i = 0; i < half; i++) {
            ans[n - 1 - i] = ans[i];
        }
    }
}