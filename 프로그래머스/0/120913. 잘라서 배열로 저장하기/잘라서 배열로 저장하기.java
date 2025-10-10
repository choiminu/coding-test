import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public String[] solution(String my_str, int n) {
        return IntStream.iterate(0, i -> i < my_str.length(), i -> i + n).mapToObj(i -> my_str.substring(i, Math.min(i + n, my_str.length()))).toArray(String[]::new);
    }
}