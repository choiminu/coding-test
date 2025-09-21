import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {
    public String solution(int num) {
        return Stream.of(num).map(i -> i % 2 == 0 ? "Even" : "Odd").collect(Collectors.joining());
    }
}