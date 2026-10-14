/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int[] index = {0};

        return build(preorder, 0, inorder.length - 1, map, index);
    }

    public TreeNode build(int[] preorder, int left, int right,
                          HashMap<Integer, Integer> map, int[] index) {

        if (left > right) {
            return null;
        }

        int value = preorder[index[0]];
        index[0]++;

        TreeNode root = new TreeNode(value);

        int middle = map.get(value);

        root.left = build(preorder, left, middle - 1, map, index);
        root.right = build(preorder, middle + 1, right, map, index);

        return root;
    }
}
