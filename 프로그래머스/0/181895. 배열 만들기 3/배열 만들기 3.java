import java.util.stream.*;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        return Arrays.stream(intervals).flatMapToInt(range -> IntStream.rangeClosed(range[0], range[1]).map(i -> arr[i])).toArray();
    }
}