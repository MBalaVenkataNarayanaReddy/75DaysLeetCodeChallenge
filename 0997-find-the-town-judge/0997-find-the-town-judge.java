class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] trustScore = new int[n + 1];

        for (int[] relation : trust) {

            int personA = relation[0];
            int personB = relation[1];

            trustScore[personA]--;
            trustScore[personB]++;
        }

        for (int person = 1; person <= n; person++) {

            if (trustScore[person] == n - 1) {
                return person;
            }
        }

        return -1;
    }
}