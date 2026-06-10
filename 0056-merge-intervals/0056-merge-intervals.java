import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int[] currentInterval = intervals[0];

        result.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart <= currentInterval[1]) {

                currentInterval[1] =
                        Math.max(currentInterval[1], currentEnd);

            } else {

                currentInterval = intervals[i];
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}