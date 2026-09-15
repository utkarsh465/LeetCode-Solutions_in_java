class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int digit = 0;
        int num = 0;
        int finalSum = 0;
        for(int i = 0;i<nums.length;i++){
            digit = nums[i];
            while(digit > 0){
                int res = digit % 10;
                num += res;
                digit = digit/10;
            }
            
        }
        finalSum += num;
        System.out.println(finalSum);
        int difference = Math.abs(sum - finalSum);
        return difference;
    }
}