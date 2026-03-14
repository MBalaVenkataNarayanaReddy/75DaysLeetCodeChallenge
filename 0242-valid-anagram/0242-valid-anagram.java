class Solution {
    public boolean isAnagram(String s, String t) {
        
        
        if (s.length() != t.length()) {
            return false;
        }

        
        int[] charCount = new int[26];

        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            charCount[currentChar - 'a']++;
        }

        
        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            charCount[currentChar - 'a']--;

            
            if (charCount[currentChar - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}