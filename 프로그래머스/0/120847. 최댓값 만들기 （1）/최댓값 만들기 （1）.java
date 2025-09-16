import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] numbers) {
        int answer = Arrays.stream(numbers)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .limit(2)
            .mapToInt(Integer::new)
            .reduce(1, (i1, i2) -> i1 * i2);
        return answer;
    }
}