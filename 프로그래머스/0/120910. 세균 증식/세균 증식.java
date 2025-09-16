import java.util.stream.IntStream;
class Solution {
    public int solution(int n, int t) {
        int answer = IntStream.range(0, t)
            .reduce(n, (i1, i2) ->  i1 * 2);
        return answer;
    }
}