class Solution {
    public String solution(int n) {
        String answer = "";
        
        char su = '수';
        char bak = '박';
        boolean flag = false;
        
        for (int i = 1; i <=n; i++) {
            if (!flag) {
                answer += su;
            } else {
                answer += bak;
            }
            flag = !flag;
        }
        
        return answer;
    }
}