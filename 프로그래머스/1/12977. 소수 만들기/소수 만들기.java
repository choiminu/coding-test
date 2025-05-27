import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        boolean[] isNotPrime = new boolean[3000 + 1];
        isNotPrime[0] = isNotPrime[1] = true;
        
        for (int i = 2; i <= Math.sqrt(3000); i++) {
            
            if (isNotPrime[i]) continue;
            
            for (int j = i + i; j <= 3000; j = j + i) {
                isNotPrime[j] = true;
            }
        }
        

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    
                    int num = nums[i] + nums[j] + nums[k];
                    
                    if (!isNotPrime[num]) answer++;
                    
                }
            }
        }

        return answer;
    }
}