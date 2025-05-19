class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        if (s.length() == 4 || s.length() == 6) {
            for (char ch : s.toCharArray()){
                if (ch >= '0' && ch <= '9') {
                    answer = true;
                } else {
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }
        
        return answer;
    }
}