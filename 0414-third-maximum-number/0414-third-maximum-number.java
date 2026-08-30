class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        TreeSet <Integer> arr = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            arr.add(nums[i]);
        }
        if (arr.size() >= 3) {
            Iterator<Integer> it = arr.descendingIterator();
            it.next();
            it.next();
            return it.next();
        }
        return arr.last();

    }
}