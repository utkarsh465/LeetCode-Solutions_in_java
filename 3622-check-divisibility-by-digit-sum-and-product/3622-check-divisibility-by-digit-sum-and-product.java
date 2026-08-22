class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int original = n;
        while(n > 0){
            int digit = n%10;
            sum += digit;
            product *= digit;
            n = n/10;
        }
        int result = sum + product;
        if(original % result == 0) {
            return true;
        }
        return false;
    }
}