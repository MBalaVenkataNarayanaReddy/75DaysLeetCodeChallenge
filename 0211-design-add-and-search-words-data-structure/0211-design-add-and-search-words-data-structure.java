class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int position, TrieNode node) {

        if (node == null) return false;

        if (position == word.length()) {
            return node.isEndOfWord;
        }

        char currentChar = word.charAt(position);

        if (currentChar == '.') {

            for (int i = 0; i < 26; i++) {
                if (searchHelper(word, position + 1, node.children[i])) {
                    return true;
                }
            }

            return false;

        } else {

            int index = currentChar - 'a';
            return searchHelper(word, position + 1, node.children[index]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */