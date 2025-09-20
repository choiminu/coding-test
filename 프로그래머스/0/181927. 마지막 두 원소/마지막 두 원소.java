import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list) {
        int n = num_list.length;
        int last = num_list[n - 1];
        int prev = num_list[n - 2];
        int extra = last > prev ? last - prev : last * 2;

        return IntStream.concat(
                    IntStream.of(num_list),
                    IntStream.of(extra)
               ).toArray();
    }
}
