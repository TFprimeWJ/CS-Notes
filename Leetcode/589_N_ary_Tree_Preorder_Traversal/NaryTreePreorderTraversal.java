import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class NaryTreePreorderTraversal {
    
    // N-ary Node Defination
    class Node {
        public int val;
        public List<Node> children;

        public Node (int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private void dfs (Node root, List<Integer> ret) {
        if (root != null) {
            ret.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                dfs(root.children.get(i), ret);
            }
        }
    }

    public List<Integer> preorder (Node root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }
}