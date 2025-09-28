import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        return IntStream.range(0, my_strings.length).mapToObj(idx -> my_strings[idx].substring(parts[idx][0], parts[idx][1] + 1)).collect(Collectors.joining());
    }
}