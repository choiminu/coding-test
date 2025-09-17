import java.util.stream.*;
class Solution {
    public String solution(String my_string) {
        String vowel = "aeiou";
        return my_string.chars()
                .filter(ch -> vowel.indexOf(ch) == -1)
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
    }
}