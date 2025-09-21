import java.util.Arrays;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        return Arrays.stream(arr)
            .boxed()
            .flatMap(x -> Arrays.stream(delete_list).anyMatch(d -> d == x) ? Stream.empty() : Stream.of(x))
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}