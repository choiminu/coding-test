import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        return IntStream.of(arr).flatMap(i -> IntStream.rangeClosed(1, i).map(j -> i)).toArray();
    }
}