class MergeTwoBinaryTrees_myfirstattempt {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int _val) {
            val = _val;
        }
    }

    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        
        TreeNode root = new TreeNode(0);
        
        if (t1 != null && t2 != null) {
            root.val = t1.val + t2.val;
        } else if (t1 != null && t2 == null) {
            root.val = t1.val;
        } else if (t1 == null && t2 != null) {
            root.val = t2.val;
        }


        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        root.left = left;
        root.right = right;
        return root;
    }
}
