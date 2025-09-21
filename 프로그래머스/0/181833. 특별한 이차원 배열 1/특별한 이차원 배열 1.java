import java.util.stream.IntStream;
class Solution {
    public int[][] solution(int n) {
        return IntStream.range(0, n).mapToObj(i -> IntStream.range(0, n).map(j -> i == j ? 1 : 0).toArray()).toArray(int[][]::new);
    }
}