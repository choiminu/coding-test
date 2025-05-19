class Solution {
    public String solution(String s) {
        String answer = "";
        
        int[] A = new int[123];
        
        for (int i = 0; i < s.length(); i++) {
            A[s.charAt(i)]++;
        }

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] != 0) {
                answer += String.valueOf((char)i).repeat(A[i]);
            }
        }
        
        return answer;
    }
}