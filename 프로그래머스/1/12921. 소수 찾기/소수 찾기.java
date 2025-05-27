import java.util.Arrays;

class Solution {
    public int solution(int n) {
        
        boolean[] isNotPrimeNumber = new boolean[1000000 + 1];
        isNotPrimeNumber[0] = isNotPrimeNumber[1] = true;
        
        for (int i = 2; i <= Math.sqrt(isNotPrimeNumber.length); i++) {
            
            if (isNotPrimeNumber[i]) {
                continue;
            }
            
            for (int j = i + i; j < isNotPrimeNumber.length; j += i) {
                isNotPrimeNumber[j] = true;
            }
            
        }
    
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (!isNotPrimeNumber[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}