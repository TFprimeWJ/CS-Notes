class SameTree_Recursion {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int _val) {
            this.val = _val;
        }
    }

    public boolean isSameTree (TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}