package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

//克隆图
public class Solution133 {
    Map<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        Node copyNode = new Node(node.val, new ArrayList<>());
        visited.put(node,copyNode);
        for(Node newNode : node.neighbors){
            if(visited.get(newNode) != null){
                copyNode.neighbors.add(visited.get(newNode));
            } else {
                copyNode.neighbors.add(cloneGraph(newNode));
            }
        }
        return copyNode;
    }
}
