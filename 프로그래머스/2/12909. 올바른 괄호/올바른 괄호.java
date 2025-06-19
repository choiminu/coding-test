import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            
            if (stack.isEmpty()) {
                stack.push(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else {
                stack.pop();
            }
            
        }
        
        answer = stack.isEmpty();

        return answer;
    }
}