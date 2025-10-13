class Solution {
    public int solution(String[] spell, String[] dic) {
 int answer = 2;

        for (String d : dic) {
            boolean flag = true;
            
            for (String s : spell) {
                if(!d.contains(s)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                answer = 1;
                break;
            }
        }

        return answer;
    }
}