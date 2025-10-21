import java.util.stream.*;
class Solution {
    public int[] solution(int[] numbers) {
        return IntStream.range(0, numbers.length)
            .flatMap(i -> IntStream.range(i + 1, numbers.length).map(j -> numbers[i] + numbers[j]))
            .distinct()
            .sorted()
            .toArray();
    }
}