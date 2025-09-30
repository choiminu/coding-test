class Solution {
    public String solution(String my_string, int[] indices) {
        char[] temp = my_string.toCharArray();
        
        for (int index : indices) {
            temp[index] = '?';
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char ch : temp) {
            if (ch != '?') {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}