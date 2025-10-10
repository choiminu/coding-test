import java.util.function.Function;
import java.util.Arrays;

class Solution {
    
    static Function<String, Integer> function = (str) -> {
            if (str.contains("americano") || str.contains("anything"))  {
                return 4500;
            } else {
                return 5000;
            }
        };
    
    public int solution(String[] order) {
        return Arrays.stream(order).mapToInt(str -> function.apply(str)).sum();
    }
}