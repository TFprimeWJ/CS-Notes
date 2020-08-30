import java.util.ArrayList;
import java.util.Stack;

class BinaryTreePreorderTraversal_Iterative {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode (int _val) { val = _val; }
    }

    // iteratively
    public List<Integer> preorderTraversal (TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                ret.add(cur.val);
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return ret;
    }
}