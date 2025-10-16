import java.util.Arrays;
import java.util.stream.*;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        return Long.parseLong(Arrays.stream(String.valueOf(n).split("")).sorted(Collections.reverseOrder()).collect(Collectors.joining()));
    }
}