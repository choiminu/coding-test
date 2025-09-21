class Solution {
    public int solution(int num, int k) {
        return String.valueOf(num).indexOf(k+'0') == -1 ? -1 : String.valueOf(num).indexOf(k+'0') + 1; 
    }
}