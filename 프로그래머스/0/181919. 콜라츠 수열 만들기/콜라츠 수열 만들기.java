import java.util.stream.*;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        
        while(n != 1) {
            if (n % 2 == 0) {
                n /= 2;
                list.add(n);
            } else {
                n = 3 * n + 1;
                list.add(n);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}