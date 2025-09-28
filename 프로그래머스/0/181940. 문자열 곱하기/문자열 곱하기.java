import java.util.stream.*;
class Solution {
    public String solution(String my_string, int k) {
        return IntStream.range(0, k).mapToObj(i -> my_string).collect(Collectors.joining());
    }
}