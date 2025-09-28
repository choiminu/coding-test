import java.util.concurrent.atomic.AtomicInteger;
import java.util.Arrays;

class Solution {
    public int solution(int[] numbers, int n) {
        return Arrays.stream(numbers)
            .map(new AtomicInteger()::addAndGet)
            .filter(s -> s > n)
            .findFirst()
            .orElseThrow();
    }
}