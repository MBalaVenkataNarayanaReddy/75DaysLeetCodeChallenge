import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        for (String word : words) {
            insert(word);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, row, col, root);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.word = word;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node) {

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }

        char currentChar = board[row][col];

        if (currentChar == '#' || node.children[currentChar - 'a'] == null) {
            return;
        }

        node = node.children[currentChar - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, node);
        dfs(board, row - 1, col, node);
        dfs(board, row, col + 1, node);
        dfs(board, row, col - 1, node);

        board[row][col] = currentChar;
    }
}