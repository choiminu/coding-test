import java.util.stream.*;
class Solution {
    public String solution(String my_string, int n) {
        return IntStream.range(0, my_string.length())
            .mapToObj(i -> String.valueOf(my_string.charAt(i)).repeat(n))
            .collect(Collectors.joining());
    }
}