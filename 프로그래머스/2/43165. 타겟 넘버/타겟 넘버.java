class Solution {
    
    static int result = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dps(numbers, 0, 0, target);
        
        answer = result;
        
        return answer;
    }
    
    public void dps(int[] A, int sum, int depth, int target) {
        if (depth == A.length) {
            if (sum == target) {
                result++;
            }
            return;
        }
        
        dps(A, sum + A[depth] * -1, depth + 1, target);
        dps(A, sum + A[depth] * 1, depth + 1, target);
        
    }
}