import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class BinaryTreePostorderTraversal_Iterative {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int _val) {
            val = _val;
        }
    }

    public List<Integer> postorderTraversal (TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        if (root == null) return ret;

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ret.addFirst(cur.val);
            if (cur.left != null) { 
                stack.push(cur.left); 
            }
            if (cur.right != null) { 
                stack.push(cur.right); 
            }
        }
        return ret;
    }
}