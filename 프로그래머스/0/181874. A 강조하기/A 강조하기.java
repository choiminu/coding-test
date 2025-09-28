import java.util.stream.*;
class Solution {
    public String solution(String myString) {
        return myString.chars().mapToObj(ch -> (char)ch == 'a' ? "A" : (char)ch == 'A' ? "A" : String.valueOf((char)ch).toLowerCase()).collect(Collectors.joining());
    }
}