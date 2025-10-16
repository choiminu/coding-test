import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        return IntStream.rangeClosed(0, 9).filter(i -> Arrays.stream(numbers).noneMatch(n -> n == i)).sum();
    }
}