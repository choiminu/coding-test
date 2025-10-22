import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(int[] food) {
        StringBuilder collect = new StringBuilder(IntStream.range(1, food.length)
                .mapToObj(i -> String.valueOf(i).repeat(food[i] / 2))
                .collect(Collectors.joining()));
        
        String left = collect.toString();
        String right = collect.reverse().toString();
        
        return left + "0" + right;
    }
}