import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(int[] numbers, String hand) {
        
        String answer = "";
        
        // col, row
        int[][] keypad = {
            {1, 3},
            {0, 0}, 
            {1, 0},
            {2, 0},
            {0 ,1},
            {1, 1},
            {2, 1},
            {0, 2},
            {1, 2},
            {2, 2},
        };
        
        int[] left = {0, 3};
        int[] right = {2, 3};        
        
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                left = keypad[num];
                answer += "L";
            } else if (num == 3 || num == 6 || num == 9) {
                right = keypad[num];
                answer += "R";
            } else {
                int leftDist = Math.abs(left[0] - keypad[num][0]) + Math.abs(left[1] - keypad[num][1]);
                int rightDist = Math.abs(right[0] - keypad[num][0]) + Math.abs(right[1] - keypad[num][1]);
                if (leftDist < rightDist) {
                    left = keypad[num];
                    answer += "L";
                } else if (leftDist > rightDist) {
                    right = keypad[num];
                    answer += "R";
                } else {
                    if (hand.equals("left")) {
                        left = keypad[num];
                        answer += "L";
                    } else {
                        right = keypad[num];
                        answer += "R";
                    }
                }
            }
        }
        
        
        return answer;
    }
}