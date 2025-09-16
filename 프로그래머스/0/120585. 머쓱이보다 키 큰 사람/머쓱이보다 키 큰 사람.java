import java.util.*;
class Solution {
    public int solution(int[] array, int height) {
        int answer = (int) Arrays.stream(array).filter(n -> n > height).count();
        return answer;
    }
}