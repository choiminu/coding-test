class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0] = gcd(n,m);
        answer[1] = answer[0] * (n / answer[0]) * (m / answer[0]); 
        
        return answer;
    }
    
    public int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd (y, x % y);
    }
}