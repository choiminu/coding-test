class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] cur = new int[2];
        
        int minX = (board[0] / 2) * -1;
        int maxX = board[0] / 2;
        int minY = (board[1] / 2) * -1;
        int maxY = board[1] / 2;
        
        int cx = cur[0];
        int cy = cur[1];
        for (String dir : keyinput) {
            
            if (dir.equals("left")){
                int nx = cx - 1;
                if (nx >= minX) cx = nx;
            }
            if (dir.equals("right")){
                int nx = cx + 1;
                if (nx <= maxX) cx = nx;
            }
            if (dir.equals("up")){
                int ny = cy + 1;
                if (ny <= maxY) cy = ny;
            }
            if (dir.equals("down")){
                int ny = cy - 1;
                if (ny >= minY) cy = ny;
            }
        }
        
        return new int[]{cx, cy};
    }
}
