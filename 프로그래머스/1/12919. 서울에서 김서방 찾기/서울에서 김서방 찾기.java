class Solution {
    public String solution(String[] seoul) {
        String answer = "seoul";
        
        int x = 0;
        for (String name : seoul) {
            if (name.equals("Kim")) {
                answer = "김서방은 " + x +"에 있다";
                break;
            }
            x++;
        }
        
        return answer;
    }
}