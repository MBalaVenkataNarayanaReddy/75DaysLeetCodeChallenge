import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> numberSet = new HashSet<>();

        for (int num : nums) {
            numberSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numberSet) {

            if (!numberSet.contains(num - 1)) {

                int currentNumber = num;
                int currentStreak = 1;

                while (numberSet.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}