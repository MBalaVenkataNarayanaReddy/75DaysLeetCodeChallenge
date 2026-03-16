import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String currentWord : strs) {

            char[] letters = currentWord.toCharArray();
            Arrays.sort(letters);

            String sortedWord = new String(letters);

            if (!anagramGroups.containsKey(sortedWord)) {
                anagramGroups.put(sortedWord, new ArrayList<>());
            }

            anagramGroups.get(sortedWord).add(currentWord);
        }

        return new ArrayList<>(anagramGroups.values());
    }
}