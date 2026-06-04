class Solution {
    public int rob(int[] nums) {

        int twoHousesBack = 0;
        int oneHouseBack = 0;

        for (int money : nums) {

            int currentBest =
                    Math.max(oneHouseBack,
                             money + twoHousesBack);

            twoHousesBack = oneHouseBack;
            oneHouseBack = currentBest;
        }

        return oneHouseBack;
    }
}