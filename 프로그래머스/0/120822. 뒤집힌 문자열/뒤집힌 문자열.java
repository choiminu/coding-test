import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        String answer = IntStream.range(0, my_string.length())
            .mapToObj(i -> my_string.charAt(my_string.length() - i - 1))
            .map(String::valueOf)
            .collect(Collectors.joining());
        
        return answer;
    }
}