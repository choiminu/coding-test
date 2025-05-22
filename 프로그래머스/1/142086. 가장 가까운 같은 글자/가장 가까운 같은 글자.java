import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] A = new int[26];
        Arrays.fill(A, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (A[index] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - A[index];
            }
            A[index] = i;
        }

        return answer;
    }
}
