import java.util.function.Function;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n, String control) {
        
        Function<Character, Integer> p = ch -> {
            if (ch == 'w') return 1;
            if (ch == 's') return -1;
            if (ch == 'd') return 10;
            if (ch == 'a') return -10;
            return 0;
        };
        
        return IntStream.range(0, control.length())
            .map(i -> p.apply(control.charAt(i)))
            .reduce(n, (i1, i2) -> i1 + i2);
    }
}