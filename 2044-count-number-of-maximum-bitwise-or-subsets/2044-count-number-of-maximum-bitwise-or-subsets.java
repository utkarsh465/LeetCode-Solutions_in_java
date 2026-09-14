class Solution {

    int maxOr = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {

        // Step 1: Find maximum possible OR
        for (int num : nums) {
            maxOr = maxOr | num;
        }

        // Step 2: Generate all subsets
        findSubsets(nums, 0, 0);

        return count;
    }

    public void findSubsets(int[] nums, int index, int currentOr) {

        // All elements have been processed
        if (index == nums.length) {

            // Ignore empty subset
            if (currentOr == maxOr) {
                count++;
            }

            return;
        }

        // Choice 1: Include current element
        findSubsets(
            nums,
            index + 1,
            currentOr | nums[index]
        );

        // Choice 2: Don't include current element
        findSubsets(
            nums,
            index + 1,
            currentOr
        );
    }
    }