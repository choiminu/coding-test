class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] answer = my_string.toCharArray();
        char[] temp = overwrite_string.toCharArray();

        for (int i = 0; i < temp.length; i++) {
            answer[i + s] = temp[i];
        }
        
        return new String(answer);
    }
}