class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int currentSum = 0;
        int minimumLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            currentSum += nums[right];

            while (currentSum >= target) {

                minimumLength = Math.min(minimumLength, right - left + 1);

                currentSum -= nums[left];
                left++;
            }
        }

        return minimumLength == Integer.MAX_VALUE ? 0 : minimumLength;
    }
}