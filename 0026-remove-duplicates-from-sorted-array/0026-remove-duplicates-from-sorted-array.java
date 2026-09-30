class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet <Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i = 0;i<list.size();i++){
            nums[i] = list.get(i);
            count++;
        }
        return count;
    }
}