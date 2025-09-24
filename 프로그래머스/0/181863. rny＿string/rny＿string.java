import java.util.stream.*;
class Solution {
    public String solution(String rny_string) {
        return rny_string.chars().mapToObj(ch -> (char)ch == 'm' ? "rn" : String.valueOf((char)ch)).collect(Collectors.joining());
    }
}