class Solution {
    public int solution(int n) {
        
        int target = Integer.bitCount(n);
        
        int temp = n + 1;
        while (Integer.bitCount(temp) != target) {
            temp++;
        }
        
        
        return temp;
    }
}