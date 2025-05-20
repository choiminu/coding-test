import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
          int answer = 0;

            int max = 0;
            int min = 0;
            for (int i = 0; i < sizes.length; i++) {
                int w = Math.max(sizes[i][0], sizes[i][1]);
                int h = Math.min(sizes[i][0], sizes[i][1]);
                max = Math.max(max, w);
                min = Math.max(min, h);
            }

            answer = max * min;

            return answer;
    }
}