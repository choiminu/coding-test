import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        return IntStream.range(0, num_list.length)
                .filter(i -> switch (n) {
                    case 1 -> i <= b;                   
                    case 2 -> i >= a;                  
                    case 3 -> i >= a && i <= b;         
                    case 4 -> i >= a && i <= b && (i - a) % c == 0;
                    default -> false;
                })
                .map(i -> num_list[i])
                .toArray();
    }
}
