import java.util.stream.*;
class Solution {
    public int solution(String myString, String pat) {
        return myString.chars().mapToObj(ch -> ch == 65 ? "B" : "A").collect(Collectors.joining()).contains(pat) ? 1 : 0;
    }
}