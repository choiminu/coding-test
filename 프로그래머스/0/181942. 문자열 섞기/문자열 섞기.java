import java.util.stream.*;

class Solution {
    public String solution(String str1, String str2) {
        return IntStream.range(0, str1.length() * 2).mapToObj(i -> i % 2 == 0 ? str1.charAt(i / 2)+"" : str2.charAt(i / 2)+"").collect(Collectors.joining());
    }
}