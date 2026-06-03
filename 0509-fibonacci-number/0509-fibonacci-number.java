class Solution {
    public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        int previousTwo = 0;
        int previousOne = 1;

        for (int currentIndex = 2; currentIndex <= n; currentIndex++) {

            int currentValue = previousOne + previousTwo;

            previousTwo = previousOne;
            previousOne = currentValue;
        }

        return previousOne;
    }
}