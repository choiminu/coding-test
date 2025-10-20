import java.util.stream.LongStream;

class Solution {
    public long solution(int price, int money, int count) {
        return Math.max(0, LongStream.rangeClosed(1, count).map(i -> (long) i * price).sum() - money);
    }
}