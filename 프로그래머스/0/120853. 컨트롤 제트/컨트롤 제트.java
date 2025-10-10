import java.util.Stack;
class Solution {
    public int solution(String s) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (String str : s.split(" ")) {
            if (str.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        
        return stack.stream().mapToInt(i -> i).sum();
    }
}