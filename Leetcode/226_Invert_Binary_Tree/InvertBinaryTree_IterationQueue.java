import java.util.LinkedList;
import java.util.Queue;

class InvertBinaryTree_IterationQueue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int _val) {
            val = _val;
        }
    }

    public TreeNode invertTree (TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
        return root;
    }
}