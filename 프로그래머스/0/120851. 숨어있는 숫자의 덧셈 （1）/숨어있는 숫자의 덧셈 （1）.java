class Solution {
    public int solution(String my_string) {
        return my_string.chars()
            .filter(ch -> Character.isDigit((char)ch))
            .map(ch -> ch - '0')
            .sum();
    }
}