import java.util.stream.*;
class Solution {
    public String solution(String my_string, String letter) {
        return IntStream.range(0, my_string.length())
            .mapToObj(i -> my_string.charAt(i))
            .filter(ch -> ch != letter.charAt(0))
            .map(String::valueOf)
            .collect(Collectors.joining());
    }
}