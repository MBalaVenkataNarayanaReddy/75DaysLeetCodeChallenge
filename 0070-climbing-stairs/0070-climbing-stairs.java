class Solution {
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int oneStepBefore = 2;
        int twoStepsBefore = 1;

        for (int currentStep = 3; currentStep <= n; currentStep++) {

            int currentWays = oneStepBefore + twoStepsBefore;

            twoStepsBefore = oneStepBefore;
            oneStepBefore = currentWays;
        }

        return oneStepBefore;
    }
}