class Solution {

    public String longestPalindrome(String s) {

        int startIndex = 0;
        int endIndex = 0;

        for (int center = 0; center < s.length(); center++) {

            int oddLength = expandFromCenter(s, center, center);
            int evenLength = expandFromCenter(s, center, center + 1);

            int currentLength = Math.max(oddLength, evenLength);

            if (currentLength > endIndex - startIndex + 1) {

                startIndex = center - (currentLength - 1) / 2;
                endIndex = center + currentLength / 2;
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

    private int expandFromCenter(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }
}