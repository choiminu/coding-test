import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        return my_string.chars()
            .mapToObj(ch -> (char)ch)
            .map(ch -> Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch))
            .map(String::valueOf)
            .collect(Collectors.joining());
    }
}