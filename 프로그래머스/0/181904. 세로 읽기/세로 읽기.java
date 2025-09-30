import java.util.stream.*;
class Solution {
    public String solution(String my_string, int m, int c) {
       return IntStream.iterate(c, i -> i <= my_string.length(), i -> i + m).mapToObj(i -> String.valueOf(my_string.charAt(i - 1))).collect(Collectors.joining());
    }
}