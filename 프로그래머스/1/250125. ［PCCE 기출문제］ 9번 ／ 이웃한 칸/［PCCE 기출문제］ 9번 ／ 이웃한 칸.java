class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int d = 0; d < 4; d++) {
            int nx = w + dx[d];
            int ny = h + dy[d];
            
            if (nx < 0 || ny < 0 || nx >= board[0].length || ny >= board.length) continue;
            if (board[h][w].equals(board[ny][nx])) answer++;
            
        }
        
        
        return answer;
    }
}