class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] can = {"aya", "ye", "woo", "ma"};
        
        for (int i = 0; i < babbling.length; i++) {
            String say = babbling[i];
            
            for (String c : can) {
                if (say.contains(c) && !say.contains(c.repeat(2))) {
                    say = say.replace(c, " ");
                }
            }
            
            if (say.trim().length() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}