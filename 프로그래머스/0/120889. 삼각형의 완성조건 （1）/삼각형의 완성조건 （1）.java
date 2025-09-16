
import java.util.*;
class Solution {
    public int solution(int[] sides) {
        IntSummaryStatistics stat = Arrays.stream(sides).summaryStatistics();
        int sum = (int) stat.getSum();
        int max = stat.getMax();
        return (sum - max) > max ? 1 : 2; 
    }
}