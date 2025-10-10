import java.util.Arrays;
class Solution {
    public int solution(String my_string) {
        return (int) Arrays.stream(my_string.toLowerCase().split("[a-z]")).filter(str -> !str.isEmpty()).mapToInt(str -> Integer.parseInt(str)).sum();
    }
}