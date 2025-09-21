import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int k) {
        return Arrays.stream(arr).map(e -> k % 2 == 0 ? e + k : e * k).toArray();
    }
}