import java.util.Stack;

class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        int[] ans = new int[3];
        System.out.println(ans[0]);
        System.out.println(ans[1]);
        System.out.println(ans[2]);
        ans[stack.peek()] = stack.pop();
        System.out.println(ans[0]);
        System.out.println(ans[1]);
        System.out.println(ans[2]);
    }
}