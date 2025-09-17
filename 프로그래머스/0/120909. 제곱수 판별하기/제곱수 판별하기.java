class Solution {
    public int solution(int n) {
        int answer = n == (int) Math.sqrt(n) * (int) Math.sqrt(n) ? 1 : 2;
        return answer;
    }
}