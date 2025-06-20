import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> left = new Stack();
        Stack<Character> right = new Stack();
        
        for (char ch : s.toCharArray()) {
            
            if (left.isEmpty() && right.isEmpty()) {
                left.push(ch);
            } else if (left.peek() == ch) {
                left.pop();
            } else if (!right.isEmpty() && right.peek() == ch) {
                right.pop();
            } else {
                left.push(ch);
            }
            
        }
        
        answer = left.isEmpty() && right.isEmpty() ? 1 : 0;
        

        return answer;
    }
}