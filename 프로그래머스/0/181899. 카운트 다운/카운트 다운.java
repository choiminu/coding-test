import java.util.stream.*;
class Solution {
    public int[] solution(int start_num, int end_num) {
        return IntStream.iterate(start_num, num -> num >= end_num, num -> num - 1).toArray();
    }
}