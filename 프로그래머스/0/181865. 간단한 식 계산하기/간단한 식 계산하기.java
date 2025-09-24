import java.util.Arrays;
class Solution {
    public int solution(String binomial) {
        
        String[] temp = binomial.split(" ");
        
        if (temp[1].trim().equals("+")) {
            return Integer.parseInt(temp[0]) + Integer.parseInt(temp[2]);
        }
        
        if (temp[1].trim().equals("-")) {
            return Integer.parseInt(temp[0]) - Integer.parseInt(temp[2]);
        }
        
        
        if (temp[1].trim().equals("*")) {
            return Integer.parseInt(temp[0]) * Integer.parseInt(temp[2]);
        }
        
        return 1;
        
    }
}