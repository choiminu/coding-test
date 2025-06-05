import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        int[] hamburger = {1,3,2,1};
        
        Stack<Integer> stack = new Stack<>();
        for (int n : ingredient) {
            stack.push(n);
            boolean isHamburger = true;
            
            if (stack.size() >= 4) {
                int[] temp = new int[4];
                
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = stack.pop();    
                }
                
                
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i] != hamburger[i]) isHamburger = false;
                }
                
                if (!isHamburger) {
                    for (int i = temp.length - 1; i >= 0; i--) {
                        stack.push(temp[i]);
                    }
                } else {
                    answer++;
                }
                
            }
        }
        
        return answer;
    }
}