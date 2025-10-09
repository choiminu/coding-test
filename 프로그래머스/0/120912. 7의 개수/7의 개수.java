import java.util.stream.*;
import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        return (int) Arrays.stream(array).mapToObj(Integer::toString).flatMapToInt(String::chars).filter(ch -> ch == 55).count();
    }
}