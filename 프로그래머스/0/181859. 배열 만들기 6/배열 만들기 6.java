import java.util.Stack;
class Solution {
    public int[] solution(int[] arr) {
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length;) {
            if (stack.isEmpty()) {
                stack.push(arr[i++]);
            } else {
                if (stack.peek() == arr[i]) {
                    stack.pop();
                    i++;
                } else {
                    stack.push(arr[i++]);
                }
            }
        }
        
        if (stack.isEmpty()) return new int[] {-1};
        
        return stack.stream().mapToInt(i -> i).toArray();
    }
}