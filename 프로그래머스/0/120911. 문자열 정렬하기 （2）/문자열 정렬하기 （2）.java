import java.util.stream.Collectors;
class Solution {
    public String solution(String my_string) {
        return my_string.chars()
            .mapToObj(ch -> String.valueOf((char)ch))
            .map(String::toLowerCase)
            .sorted()
            .collect(Collectors.joining());
    }
}