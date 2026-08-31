class Solution {
    public int minElement(int[] nums) {
       int arr [] = new int[nums.length];
       for(int i = 0; i<nums.length;i++){
        int num = nums[i];
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            sum += digit;
            num = num/10;
        }
        arr[i] = sum;
       }
       int min = Integer.MAX_VALUE;
       for(int i = 0;i<arr.length;i++){
        min = Math.min(min,arr[i]);
       }
       return min; 
    }
}