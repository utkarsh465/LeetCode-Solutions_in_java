class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        ArrayList <Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                list.add(nums[i]);
            }
        }
        int arr[] = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}