import java.util.stream.*;

class Solution {
    public int solution(String myString, String pat) {
        return (int) IntStream.rangeClosed(0, myString.length() - pat.length()).filter(i -> myString.substring(i, i + pat.length()).equals(pat)).count();
    }
}