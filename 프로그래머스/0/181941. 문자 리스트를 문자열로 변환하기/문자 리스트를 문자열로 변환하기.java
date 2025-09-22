import java.util.stream.Collectors;
import java.util.Arrays;

class Solution {
    public String solution(String[] arr) {
        return Arrays.stream(arr).collect(Collectors.joining());
            
    }
}