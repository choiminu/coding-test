class Solution {
    public int[] solution(int n, int m) {
        return new int[] {gcd(n,m), n / gcd(n,m) * m / gcd(n,m) * gcd(n,m)};
    }
    
    public int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}