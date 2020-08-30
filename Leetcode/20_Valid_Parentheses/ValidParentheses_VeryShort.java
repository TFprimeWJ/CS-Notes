import java.util.Stack;

class ValidParentheses_VeryShort {
    private Stack<Character> stack = new Stack<Character>();

    public boolean isValid (String s) {
        for (char c : s.toCharArray()) {
            if (c == '(') 
                stack.push(')');
            else if (c == '[') 
                stack.push(']');
            else if (c == '{') 
                stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) 
                return false;
        }
        return stack.isEmpty();
    }
}