class InvertBinaryTree_191214 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int _val) {
            val = _val;
        }
    }
    public TreeNode invertTree (TreeNode root) {
        changeSide(root);
        return root;
    }

    private void changeSide (TreeNode t) {
        // Change left side and right side of TreeNode t
        if (t == null) return;
        if (t.left == null && t.right == null) return;
        TreeNode temp = new TreeNode();
        temp = t.left;
        t.left = t.right;
        t.right = temp;
        changeSide(t.left);
        changeSide(t.right);
    }
}