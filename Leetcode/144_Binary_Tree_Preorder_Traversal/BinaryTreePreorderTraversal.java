import java.util.ArrayList;
import java.util.List;

class BinaryTreePreorderTraversal {
    
    // Defination of a binary tree node
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int x) { val = x; }
    }

    private void dfs (TreeNode root, List<Integer> ret) {
        if (root != null) {
            ret.add(root.val);
            dfs(root.left, ret);
            dfs(root.right, ret);
        }
    }

    // Solution - Binary Tree Preorder Traversal
    public List<Integer> preorderTraversal (TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }
}