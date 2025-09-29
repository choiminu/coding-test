import java.util.stream.*;

class Solution {
    public String solution(int age) {
        return String.valueOf(age).chars().mapToObj(ch -> String.valueOf( (char) (ch-'0'+'a'))).collect(Collectors.joining());
    }
}