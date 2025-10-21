import java.util.stream.*;
class Solution {
    public String solution(String s, int n) {
        return s.chars().mapToObj(ch -> {
            if (ch == ' ') return " ";
            if (Character.isLowerCase(ch)) {
                return String.valueOf((char) ('a' + (ch - 'a' + n) % 26));
            } else if (Character.isUpperCase(ch)) {
                return String.valueOf((char) ('A' + (ch - 'A' + n) % 26));
            } else {
                return String.valueOf((char) ch);
            }
        })
        .collect(Collectors.joining());
    }
}