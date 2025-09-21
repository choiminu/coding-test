
class Solution {
    public int[] solution(long n) {
        return new StringBuilder(Long.toString(n)).reverse().chars().map(c -> c - '0').toArray();
    }
}