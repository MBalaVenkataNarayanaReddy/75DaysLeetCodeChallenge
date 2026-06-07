class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            dp[i] = 100000;
        }

        dp[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {

            for (int coin : coins) {

                if (currentAmount >= coin) {

                    int remainingAmount = currentAmount - coin;

                    dp[currentAmount] = Math.min(
                            dp[currentAmount],
                            dp[remainingAmount] + 1
                    );
                }
            }
        }

        if (dp[amount] == 100000) {
            return -1;
        }

        return dp[amount];
    }
}