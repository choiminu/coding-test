import java.util.function.BiFunction;
class Solution {
    public int solution(int a, int b) {
        BiFunction<Integer, Integer, Integer> func = (x, y) -> {
            if (x % 2 != 0 && y % 2 != 0) return (int) Math.pow(x, 2) + (int) Math.pow(y, 2);
            if (x % 2 != 0 || y % 2 != 0) return 2 * (x + y);
            return Math.abs(x - y);
        };
        return func.apply(a,b);
    }
}