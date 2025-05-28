class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int wx = wallet[0];
        int wy = wallet[1];
        
        int bx = bill[0];
        int by = bill[1];
        
        while (true) {
            
            if ((wx >= bx && wy >= by) || (wx >= by && wy >= bx)) {
                break;
            }
            
            if (bx > by) {
                bx = bx / 2;
            } else {
                by = by / 2;
            }
            
            answer++;
        }
        
        return answer;
    }
}