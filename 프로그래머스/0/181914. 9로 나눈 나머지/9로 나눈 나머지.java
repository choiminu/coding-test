class Solution {
    public int solution(String number) {
        return number.chars().map(ch -> ch - '0').sum() % 9;
    }
}