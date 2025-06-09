class Solution {
    public int[] solution(String[] wallpaper) {
        
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MAX_VALUE;
        
        int minY = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
    
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, j);
                    maxX = Math.min(maxX, i);
                    
                    minY = Math.max(minY, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        int[] answer = {maxX, minX, minY + 1, maxY + 1};
        
        return answer;
    }
}