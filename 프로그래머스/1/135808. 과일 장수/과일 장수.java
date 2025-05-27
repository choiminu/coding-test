import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        for (int i = score.length - 1; i >= 0; i -= m) {
            
            int start = i - m + 1;
            
            if (start >= 0) {
                answer += score[start] * m; 
            }
            
        }
        
        return answer;
    }
}