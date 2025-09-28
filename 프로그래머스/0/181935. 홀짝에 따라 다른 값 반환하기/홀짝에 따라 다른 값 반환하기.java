import java.util.stream.*;
import java.util.Map;
class Solution {
    public int solution(int n) {
        Map<Boolean, Integer> map = IntStream.rangeClosed(1, n)
            .boxed()
            .collect(Collectors.partitioningBy(i -> i % 2 == 0, Collectors.summingInt(i -> (i % 2 == 0) ? i * i : i)));
        return n % 2 == 0 ? map.get(true) : map.get(false);
    }
}