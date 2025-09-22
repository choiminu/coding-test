import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list) {
        return IntStream.of(num_list).sorted().limit(5).toArray();
    }
}