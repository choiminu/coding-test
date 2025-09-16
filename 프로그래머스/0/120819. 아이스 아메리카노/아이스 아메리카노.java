import java.util.stream.*;

class Solution {
    public int[] solution(int money) {
        return IntStream.rangeClosed(2, 3).map(i -> i % 2 == 0 ? money / 5500 : money % 5500).toArray();
    }
}