import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        for (int num : d) {
            if (budget >= num) {
                budget -= num;
                answer++;
            }else {
                break;
            }
        }
        
        return answer;
    }
}