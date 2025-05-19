class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        while(left <= right) {
            int count = 0;
            
            for (int i = 1; i <= left; i++) {
                if (left % i == 0) {
                    count++;
                }
            }
            
            answer = count % 2 == 0 ? answer + left : answer - left;
            
            left++;
            
        }
        return answer;
    }
}