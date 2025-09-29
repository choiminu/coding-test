class Solution {
    public int solution(int order) {
        return (int) String.valueOf(order).chars().map(ch -> ch - '0').filter(i -> i == 3 || i == 6 || i == 9).count();
    }
}