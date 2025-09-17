import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        Map<Boolean, Long> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.partitioningBy(
                        i -> i % 2 == 0,  
                        Collectors.counting()
                ));

        return new int[] {
            map.get(true).intValue(),
            map.get(false).intValue()
        };
    }
}
