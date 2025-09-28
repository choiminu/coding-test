class Solution {
    public int solution(int a, int b) {
        int plus = Integer.parseInt(a+""+b);
        int mul = 2 * a * b;
        return plus > mul ? plus : mul;
    }
}