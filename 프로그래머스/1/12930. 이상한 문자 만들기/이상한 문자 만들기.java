import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        return Arrays.stream(s.split(" ", -1))
                .map(word -> IntStream.range(0, word.length())
                        .mapToObj(i -> (i % 2 == 0)
                                ? String.valueOf(Character.toUpperCase(word.charAt(i)))
                                : String.valueOf(Character.toLowerCase(word.charAt(i))))
                        .collect(Collectors.joining("")))
                .collect(Collectors.joining(" "));
    }
}
