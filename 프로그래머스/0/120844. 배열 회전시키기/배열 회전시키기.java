import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
       return IntStream.range(0, numbers.length)
           .map(i -> {
               if (direction.equals("right")) {
                   return numbers[(i - 1 + numbers.length) % numbers.length];
               } else {
                   return numbers[(i + 1) % numbers.length];
               }
           }).toArray();
    }
}