import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> currentWindow = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);

            while (currentWindow.contains(currentChar)) {
                currentWindow.remove(s.charAt(left));
                left++;
            }

            currentWindow.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}