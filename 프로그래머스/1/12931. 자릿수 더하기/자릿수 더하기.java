import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int n) {
        return IntStream.range(0, String.valueOf(n).length())
            .map(i -> String.valueOf(n).charAt(i) - '0')
            .sum();
    }
}