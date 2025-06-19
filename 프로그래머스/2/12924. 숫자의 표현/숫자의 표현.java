class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int left = 1, right = 1, sum = 1;
        
        while (left <= n / 2) {
            if (sum == n) {
                answer++;
                sum -= left;
                left++;
            } else if (sum < n) {
                sum += ++right;
            } else {
                sum -= left++;
            }
        }
        
        return answer + 1;
    }
}