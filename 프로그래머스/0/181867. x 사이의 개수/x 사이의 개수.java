import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

class Solution {
    public int[] solution(String myString) {
        return Arrays.stream(myString.split("x", -1))
                     .mapToInt(String::length)
                     .toArray();
    }
}