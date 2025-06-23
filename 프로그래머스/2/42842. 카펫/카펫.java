class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for (int height = 3; height <= total / 3; height++) {
            if (total % height != 0) continue;
            
            int width = total / height;
            int inner = (width - 2) * (height - 2);
            
            if (inner == yellow) {
                return new int[] {width, height};
            }
        }
        return new int[0];
    }
}