import java.util.Stack;

class ValidParentheses{
    public boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (compareClose(x)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char curr = stack.pop();
                if (!(x - curr > 0 && x - curr < 3)) {
                    return false;
                }
            } else {
                stack.push(x);
            }
        }
        return stack.isEmpty();
    }
    private boolean compareClose (char x) {
        char[] close = new char[]{")", "]", "}"};
        for (char i : close) {
            if (x == i) return true;
        }
        return false;
    }
}