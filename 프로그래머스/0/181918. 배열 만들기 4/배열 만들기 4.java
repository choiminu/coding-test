import java.util.Stack;
class Solution {
    public int[] solution(int[] arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; ) {
            
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                i++;
                continue;
            }
            
            if (stack.peek() < arr[i]) {
                stack.push(arr[i]);
                i++;
                continue;
            } else {
                stack.pop();
            }
        }
        
        
        return stack.stream().mapToInt(i -> i).toArray();
    }
}