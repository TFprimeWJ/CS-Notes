import java.util.LinkedList;
import java.util.Queue;

class SymmetricTree_Iteration {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int _val) {
            this.val = _val;
        }
    }

    public boolean isSymmetric (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        if (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) return true;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
    }
}