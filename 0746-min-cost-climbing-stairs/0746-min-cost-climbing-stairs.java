class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int twoStepsBefore = cost[0];
        int oneStepBefore = cost[1];

        for (int currentStep = 2; currentStep < cost.length; currentStep++) {

            int currentCost =
                    cost[currentStep] +
                    Math.min(oneStepBefore, twoStepsBefore);

            twoStepsBefore = oneStepBefore;
            oneStepBefore = currentCost;
        }

        return Math.min(oneStepBefore, twoStepsBefore);
    }
}