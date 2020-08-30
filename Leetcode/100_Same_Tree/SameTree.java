class SameTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int _val) {
            this.val = _val;
        }
    }

    public boolean isSameTree (TreeNode t1, TreeNode t2) {
        return isSameNode(t1, t2);
    }

    private boolean isSameNode (TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isSameNode(t1.left, t2.left) && isSameNode(t1.right, t2.right);
    }
}