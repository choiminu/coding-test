import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] num_list) {
        return Arrays.stream(num_list).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0,Collectors.mapping(String::valueOf, Collectors.joining()))).entrySet().stream().mapToInt(i -> Integer.parseInt(i.getValue())).sum();
    }
}