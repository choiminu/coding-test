import java.util.Arrays;
class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = (int) Arrays.stream(s1).filter(s -> Arrays.asList(s2).contains(s)).count();
        return answer;
    }
}