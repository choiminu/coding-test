import java.util.stream.IntStream;

class Solution {
    public int solution(String my_string, String is_suffix) {
        return IntStream.range(0, my_string.length()).anyMatch(i -> my_string.substring(i).equals(is_suffix)) ? 1 : 0;
    }
}
