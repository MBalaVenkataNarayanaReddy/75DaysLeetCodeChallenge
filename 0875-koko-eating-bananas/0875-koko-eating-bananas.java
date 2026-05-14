class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for (int bananas : piles) {
            right = Math.max(right, bananas);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            int totalHours = 0;

            for (int bananas : piles) {
                totalHours += (bananas + mid - 1) / mid;
            }

            if (totalHours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}