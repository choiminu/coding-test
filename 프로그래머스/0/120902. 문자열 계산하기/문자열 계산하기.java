class Solution {
    public int solution(String my_string) {
        
        String[] split = my_string.split(" ");
        
        int answer = Integer.parseInt(split[0]);
        
        boolean plus = true;
        for (int i = 1; i < split.length; i++) {
            
            String next = split[i];
            if (i % 2 != 0) {
                plus = next.equals("+");
            } else {
                answer += plus ? Integer.parseInt(next) : -Integer.parseInt(next);
            }
        }
        
        return answer;
    }
}