class Solution {
    public String solution(int a, int b) {
        String[] days = {"SAT", "SUN", "MON", "TUE", "WED", "THU", "FRI"};
        
        int k = 16;
        int j = 20;
        
        if (a < 3) {
            a += 12;
            k--;
        }
        
        int h = ((b + (13 * (a + 1) / 5) + k + k / 4 + j / 4 - 2 * j) + 7) % 7;
        
        return days[h];
    }
}