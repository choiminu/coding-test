class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(char ch : s.toCharArray()) {
            int count = 0;
            while (count < index) {
                ch++;
                if (ch > 'z') ch = 'a';
                if (!skip.contains(String.valueOf(ch))) count++;
            }
            answer += ch;
        }
        
        return answer;
    }
}