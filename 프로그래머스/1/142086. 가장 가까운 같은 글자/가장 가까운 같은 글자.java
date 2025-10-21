class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = 0;
            for (int j = 0; j < i; j++) {
                if (ch == s.charAt(j)) {
                    index = i - j;
                }
            }
            answer[i] = index == 0 ? -1 : index;
        }
        
        return answer;
    }
}