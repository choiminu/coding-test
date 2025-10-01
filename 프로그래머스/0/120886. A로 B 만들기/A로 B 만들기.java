import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String before, String after) {
        String sortedBefore = before.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        String sortedAfter = after.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        return sortedBefore.equals(sortedAfter) ? 1 : 0;
    }
}