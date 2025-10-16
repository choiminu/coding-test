import java.util.stream.IntStream;

class Solution {
    public String solution(String[] seoul) {
        return "김서방은 " + IntStream.range(0, seoul.length).filter(i -> seoul[i].equals("Kim")).findFirst().getAsInt() + "에 있다";
    }
}