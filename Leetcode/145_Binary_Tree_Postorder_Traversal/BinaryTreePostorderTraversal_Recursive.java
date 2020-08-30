import java.util.ArrayList;
import java.util.List;

class BinaryTreePostorderTraversal_Recursive {
    // TreeNode difination
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int _val) {
            val = _val;
        }
    }

    // Binary Tree Postorder Traversal: Recursive
    private void dfs (TreeNode root, List<Integer> ret) {
        if (root != null) {
            dfs(root.left, ret);
            dfs(root.right, ret);
            ret.add(root.val);
        }
    }

    public List<Integer> postorderTraversal (TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }
}