import java.util.stream.*;
class Solution {
    public String solution(String n_str) {
        return n_str.chars().dropWhile(ch -> ch == '0').mapToObj(ch -> String.valueOf((char)ch)).collect(Collectors.joining());
    }
}