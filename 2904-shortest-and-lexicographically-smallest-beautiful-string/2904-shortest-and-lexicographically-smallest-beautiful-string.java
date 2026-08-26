class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int ones = 0;

        String ans = "";
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            if (s.charAt(right) == '1') {
                ones++;
            }

            // Too many 1s -> move left
            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            // Remove unnecessary leading 0s
            while (ones == k && s.charAt(left) == '0') {
                left++;
            }

            // We have exactly k ones
            if (ones == k) {

                int length = right - left + 1;
                String current = s.substring(left, right + 1);

                // First condition: shorter substring
                if (length < minLength) {
                    minLength = length;
                    ans = current;
                }

                // Second condition: same length but lexicographically smaller
                else if (length == minLength && current.compareTo(ans) < 0) {
                    ans = current;
                }
            }
        }

        return ans;
    }
}