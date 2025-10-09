import java.util.stream.*;
class Solution {
    public int solution(int i, int j, int k) {
        return (int) IntStream.rangeClosed(i, j).mapToObj(Integer::toString).flatMapToInt(String::chars).filter(ch -> ch == k + '0').count();
    }
}