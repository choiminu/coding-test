import java.util.stream.*;
class Solution {
    public int solution(int[] arr, int idx) {
        return IntStream.range(0, arr.length).filter(i -> idx <= i && arr[i] == 1).findFirst().orElse(-1);
    }
}