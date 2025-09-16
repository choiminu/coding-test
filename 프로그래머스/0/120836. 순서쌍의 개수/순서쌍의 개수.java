import java.util.stream.*;
class Solution {
    public int solution(int n) {
        int answer = (int) IntStream.rangeClosed(1, n).filter(i -> n % i == 0).count();
        return answer;
    }
}