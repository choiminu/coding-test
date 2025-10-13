import java.util.Arrays;

class Solution {
    public int solution(String[] spell, String[] dic) {
        return Arrays.stream(dic).anyMatch(d -> Arrays.stream(spell).allMatch(d::contains)) ? 1 : 2;
    }
}
