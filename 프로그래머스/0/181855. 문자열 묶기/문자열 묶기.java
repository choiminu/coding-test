import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, List<String>> collect = Stream.of(strArr).collect(Collectors.groupingBy(i -> i.length()));

        int max = 0;
        for (Integer i : collect.keySet()) {
            max = Math.max(max, collect.get(i).size());
        }

        return max;
    }
}