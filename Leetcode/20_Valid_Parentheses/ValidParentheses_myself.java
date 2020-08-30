import java.util.Stack;

class ValidParentheses_myself {
    private Stack<Character> stack = new Stack<>();

    public boolean isValid (String s) {
        for (char i : s.toCharArray()) {
            if (compareClose(i)) {
                // ')', ']', '}'
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                // check if pairs
                if ((i - last != 1) && (i - last != 2)) {
                    return false;
                }
            } else {
                // '(', '[', '{'
                // add to the stack
                stack.push(i);
            }
        }
        return stack.isEmpty();
    }

    private boolean compareClose (char x) {
        char[] close = new char[]{')', ']', '}'};
        for (char i : close) {
            if (i == x) return true;
        }
        return false;
    }
}