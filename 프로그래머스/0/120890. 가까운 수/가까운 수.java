import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        return Arrays.stream(array).boxed().min(Comparator.comparingInt((Integer a) -> Math.abs(a - n)) .thenComparingInt(a -> a)) .get(); 
    }
}
