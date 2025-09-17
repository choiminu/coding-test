import java.util.stream.*;
class Solution {
    public int[] solution(String my_string) {
        return IntStream.range(0, my_string.length())
                        .filter(i -> my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9')
                        .map(i -> my_string.charAt(i) - '0')
                        .sorted()
                        .toArray();
    }
}