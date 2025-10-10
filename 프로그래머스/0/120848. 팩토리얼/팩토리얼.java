class Solution {
    public int solution(int n) {
        int[] dp = new int[11];
        dp[0] = 1;
        for (int i = 1; i <= 10; i++) {
            dp[i] = dp[i - 1] * i;
        }

        int answer = 0;
        for (int i = 1; i <= 10; i++) {
            if (dp[i] > n) {
                answer = i - 1;
                break;
            }
            answer = i;
        }

        return answer;
    }
}
