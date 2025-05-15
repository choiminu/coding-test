class Solution {
    public int solution(int[] numbers) {
        
        int[] A = new int[10];
        for (int i = 0; i < 10; i++) {
            A[i] = i;
        }
        
        for (int i = 0; i < numbers.length; i++) {
            A[numbers[i]] = 0;
        }
        
        int answer = 0;
        for (int num : A) {
            answer += num;
        }
        
        return answer;
    }
}