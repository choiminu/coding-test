import java.util.stream.*;
class Solution {
    public String solution(String myString) {
        return myString.chars().mapToObj(ch -> ch < 108 ? "l" : String.valueOf((char)ch)).collect(Collectors.joining());
    }
}