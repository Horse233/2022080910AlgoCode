import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. 逆波兰表达式求值
 */
public class Code_9_27_evaluate_reverse_polish_notation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (tokens[i].equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (tokens[i].equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (tokens[i].equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
