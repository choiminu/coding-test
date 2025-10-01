import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        
        int length = 1;
        
        while (arr.length > length) {
            length *= 2;
        }
        
        return IntStream.range(0, length).map(i -> i < arr.length ? arr[i] : 0).toArray();
    }
}