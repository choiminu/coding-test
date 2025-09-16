import java.util.stream.IntStream;
class Solution {
    public int solution(int n) {
        int answer = IntStream.range(0, String.valueOf(n).length())
            .map(i -> String.valueOf(n).charAt(i) - '0')
            .sum();
        return answer;
    }
}