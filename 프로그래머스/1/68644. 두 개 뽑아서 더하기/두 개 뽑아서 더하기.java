class Solution {
    public int[] solution(int[] numbers) {
        int[] A = new int[200];
    
        int cnt = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int index = numbers[i] + numbers[j];
                
                if (i == j) continue;
                
                if (A[index] == 0) {
                    A[index]++;
                    cnt++;
                }
            }
        }
        
        int[] answer = new int[cnt];
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                answer[index] = i;
                index++;
            }            
        }
        
        return answer;
    }
}