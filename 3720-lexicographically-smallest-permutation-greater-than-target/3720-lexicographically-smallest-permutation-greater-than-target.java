class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {

            int cur = target.charAt(i) - 'a';

            // Try to keep the prefix equal to target
            if (freq[cur] > 0) {
                freq[cur]--;
                prefix.append(target.charAt(i));
                continue;
            }

            // We cannot continue with the same character.
            // Find the smallest character greater than target[i].
            for (int j = cur + 1; j < 26; j++) {

                if (freq[j] > 0) {

                    StringBuilder ans = new StringBuilder(prefix);

                    // Make this position greater
                    ans.append((char) ('a' + j));
                    freq[j]--;

                    // Fill remaining positions with smallest characters
                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return ans.toString();
                }
            }

            // No greater character here.
            // Need to backtrack to an earlier position.
            break;
        }

        /*
         * If we reach here, the prefix matched target
         * as far as possible.
         *
         * Now backtrack from the end.
         */
        freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        prefix = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {

            int cur = target.charAt(i) - 'a';

            if (freq[cur] == 0) {
                break;
            }

            freq[cur]--;
            prefix.append(target.charAt(i));
        }

        // Backtrack
        for (int i = prefix.length() - 1; i >= 0; i--) {

            int removed = prefix.charAt(i) - 'a';
            freq[removed]++;

            int cur = target.charAt(i) - 'a';

            for (int j = cur + 1; j < 26; j++) {

                if (freq[j] > 0) {

                    StringBuilder ans =
                        new StringBuilder(prefix.substring(0, i));

                    ans.append((char) ('a' + j));
                    freq[j]--;

                    // Smallest possible suffix
                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}