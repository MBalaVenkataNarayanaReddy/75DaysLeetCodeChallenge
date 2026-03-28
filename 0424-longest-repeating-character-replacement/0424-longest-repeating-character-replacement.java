class Solution {
    public int characterReplacement(String s, int k) {

        int[] charFrequency = new int[26];

        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);
            charFrequency[currentChar - 'A']++;

            maxFrequency = Math.max(maxFrequency, charFrequency[currentChar - 'A']);

            while ((right - left + 1) - maxFrequency > k) {
                charFrequency[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}