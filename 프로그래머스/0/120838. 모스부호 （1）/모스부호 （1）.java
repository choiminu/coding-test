class Solution {
    public String solution(String letter) {
        String[] morses = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        String answer = "";
        
        for (String str : letter.split(" ")) {
            for (int i = 0; i < morses.length; i++) {
                if (str.equals(morses[i])) {
                    answer += (char) (i + 'a');
                }
            }
        }
        return answer;
    }
}