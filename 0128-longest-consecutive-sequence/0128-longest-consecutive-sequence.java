class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0){
            return 0;
        }
        else if(nums.length == 1){
            return 1;
        }
        int count = 1;
        int x = 0;
        int maxCount = 0;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i+1] - nums[i] == 1){
                count++;
            }
            else if(nums[i+1] == nums[i]){
                x++;
            }
            else{
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}