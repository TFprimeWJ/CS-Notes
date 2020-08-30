import java.util.Stack;

class MaximumDepthOfBinaryTree_Recursion {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int _val) {
            this.val = _val;
        }
    }

    public int maxDepth (TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return java.lang.Math.max(leftDepth, rightDepth) + 1;
    }
}