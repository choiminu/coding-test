import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    static int row;
    static int col;
    
    static int[][] map;
    static boolean[][] isVisited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        map = maps;
        row = maps.length;
        col = maps[0].length;
        isVisited = new boolean[row][col];
        
        answer = bfs();
        
        return answer;
    }
    
    public int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1});
        isVisited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];
            
            if (cx == col - 1 && cy == row - 1) {
                return dist;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= col || ny >= row) continue;
                if (map[ny][nx] == 0 || isVisited[ny][nx]) continue;
                
                queue.offer(new int[]{nx,ny,dist + 1});
                isVisited[ny][nx] = true;
            }
        }
        
        return -1;
    }
}