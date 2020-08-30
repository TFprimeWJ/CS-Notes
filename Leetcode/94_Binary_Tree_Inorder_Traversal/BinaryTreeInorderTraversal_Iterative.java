import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeInorderTraversal_Iterative {
    // TreeNode defination
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int _val) {
            val = _val;
        }
    }

    // Iterative
    public List<Integer> inorderTraversal (TreeNode root) {
        List<Integer> ret = new ArrayList<>(); // store result
        Stack<TreeNode> stack = new Stack<>(); // When implementing iteratively, we need stack
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ret.add(cur.val);
            cur = cur.right;
        }
        return ret;
    }
}