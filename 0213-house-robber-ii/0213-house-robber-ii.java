class Solution {

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(
                robRange(nums, 0, nums.length - 2),
                robRange(nums, 1, nums.length - 1)
        );
    }

    private int robRange(int[] nums, int start, int end) {

        int twoHousesBack = 0;
        int oneHouseBack = 0;

        for (int index = start; index <= end; index++) {

            int currentBest =
                    Math.max(oneHouseBack,
                             nums[index] + twoHousesBack);

            twoHousesBack = oneHouseBack;
            oneHouseBack = currentBest;
        }

        return oneHouseBack;
    }
}