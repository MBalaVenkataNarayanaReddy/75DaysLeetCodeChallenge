class Solution {
    public String minWindow(String s, String t) {

        int[] need = new int[128];
        int[] have = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int count = 0;

        int start = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            have[c]++;

            if (have[c] <= need[c]) {
                count++;
            }

            while (count == t.length()) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                have[leftChar]--;

                if (have[leftChar] < need[leftChar]) {
                    count--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}