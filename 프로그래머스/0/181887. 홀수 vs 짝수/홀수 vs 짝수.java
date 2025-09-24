import java.util.stream.*;
import java.util.Map;

class Solution {
    public int solution(int[] num_list) {
        Map<Boolean, Integer> map = IntStream.range(0, num_list.length)
            .boxed()
            .collect(Collectors.partitioningBy(i -> i % 2 == 0, Collectors.summingInt(j -> num_list[j])));
        
        return Math.max(map.get(false), map.get(true));
    }
}