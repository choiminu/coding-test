import java.math.BigInteger;
import java.util.stream.IntStream;

class Solution {
    public int solution(String t, String p) {
        BigInteger target = new BigInteger(p);
        return (int) IntStream.rangeClosed(0, t.length() - p.length())
                .mapToObj(i -> new BigInteger(t.substring(i, i + p.length())))
                .filter(v -> v.compareTo(target) <= 0)
                .count();
    }
}
