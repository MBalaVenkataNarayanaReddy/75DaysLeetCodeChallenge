/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.*;

class Solution {

    private Map<Node, Node> clonedNodes = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        if (clonedNodes.containsKey(node)) {
            return clonedNodes.get(node);
        }

        Node copiedNode = new Node(node.val);
        clonedNodes.put(node, copiedNode);

        for (Node neighbor : node.neighbors) {
            copiedNode.neighbors.add(cloneGraph(neighbor));
        }

        return copiedNode;
    }
}