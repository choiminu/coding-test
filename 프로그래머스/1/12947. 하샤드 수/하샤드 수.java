class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int temp = x;
        int sum = 0;
        
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        
        answer = x % sum == 0;
        
        return answer;
    }
}