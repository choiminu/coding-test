import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        return IntStream.of(num_list).skip(n - 1).toArray();
    }
}