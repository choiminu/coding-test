class Solution {
    public String solution(String s) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] temp = s.split(" ");
        
        for (String t : temp) {
            int num = Integer.parseInt(t);
            
            if (num >= max) {
                max = num;
            }
            
            if (num <= min) {
                min = num;
            }
        }
        
        
        String answer = min + " " + max;
        return answer;
    }
}