import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class BinaryTreeInorderTraversal_Recursive {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    private void dfs (TreeNode root, List<Integer> ret) {
        if (root != null) {
            dfs(root.left, ret);
            ret.add(root.val);
            dfs(root.right, ret);
        }
    }

    public List<Integer> inorderTraversal (TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }
}