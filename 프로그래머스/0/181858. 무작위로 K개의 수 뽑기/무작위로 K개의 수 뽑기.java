import java.util.Arrays;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        
        int[] answer = new int[k];
        
        arr = Arrays.stream(arr).distinct().toArray();
        for (int i = 0; i < k; i++) {
            if (i < arr.length) {
                answer[i] = arr[i];        
            } else {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}