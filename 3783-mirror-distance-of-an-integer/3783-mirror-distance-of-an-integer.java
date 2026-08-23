class Solution {
    public int mirrorDistance(int n) {
        int revDigit = 0;
        int original = n;
        while(n > 0){
            int digit = n%10;
            revDigit = revDigit * 10 + digit;
            n = n/10;
        }
        int diff = Math.abs(original - revDigit);
        return diff;
    }
}