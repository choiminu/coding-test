import java.util.Arrays;
class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        for (int i = 0; i < emergency.length; i++) {
            int priority = 1;
            for (int j = 0; j < emergency.length; j++) {
                if (i == j) continue;
                if (emergency[i] < emergency[j]) priority++;
            }
            answer[i] = priority;
        }
        
        return answer;
    }
}