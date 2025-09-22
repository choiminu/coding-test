import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int n) {
        boolean isOdd = arr.length % 2 != 0;
        return IntStream.range(0, arr.length)
            .map(i -> (isOdd && i % 2 == 0) || (!isOdd && i % 2 != 0)
                        ? arr[i] + n
                        : arr[i])
            .toArray();
    }
}