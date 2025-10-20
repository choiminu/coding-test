import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        return s.chars().boxed().sorted((a, b) -> b - a).map(ch -> String.valueOf((char)ch.intValue())).collect(Collectors.joining());
    }
}