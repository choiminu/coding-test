import java.util.stream.*;
class Solution {
    public String solution(String my_string, String alp) {
        return my_string.chars()
            .mapToObj(ch -> String.valueOf((char)ch))
            .map(ch -> ch.equals(alp) ? ch.toUpperCase() : ch)
            .collect(Collectors.joining());
    }
}