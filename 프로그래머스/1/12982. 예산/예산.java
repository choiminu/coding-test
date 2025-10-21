import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int answer = 0;

        for (int num : d) {
            if (num <= budget) {
                answer++;
                budget -= num;
            }
        }
        
        return answer;
    }
}