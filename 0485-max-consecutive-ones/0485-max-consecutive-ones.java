class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int answer = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
            } else {
                answer = Math.max(answer, cnt);
                cnt = 0;
            }
        }
        
        if (cnt != 0) {
            answer = Math.max(answer, cnt);
        }
        
        return answer;
        
    }
}