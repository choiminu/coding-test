import java.io.*;
import java.util.*;

public class Main{
    static int n, m, k;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for(int i=0; i < n; i++){
            String s = br.readLine();
            for(int j=0; j < m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        int ans = bfs();
        System.out.println(ans);
        br.close();
    }
    
    private static int bfs(){
        // 각 위치에 부순 벽의 수를 기입하는 배열
        int[][] broken = new int[n][m];
        for(int i=0; i < n; i++){
            Arrays.fill(broken[i], Integer.MAX_VALUE);
        }
        Queue<Pos> q = new LinkedList<>();
        
        // 처음 위치 - 낮 시간대로 설정
        q.offer(new Pos(0, 0, 0, 1, true));
        broken[0][0] = 0; // 최초 위치에서 부순 벽의 수는 0개
        
        int ny, nx;
        while(!q.isEmpty()){
            Pos c = q.poll();
            if(c.y == n-1 && c.x == m-1) {
                return c.m;
            }
            
            for(int i=0; i < 4; i++){
                ny = c.y + dy[i];
                nx = c.x + dx[i];
                
                // 범위를 벗어났거나 이미 부순 벽의 수가 더 많다면 넘어간다.
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || broken[ny][nx] <= c.w) continue;
                // 벽의 위치라면
                if(map[ny][nx] == 1){
                    // 최대 부술 수 있는 벽을 이미 다 부순 경우는 진행 불가
                    if(c.w >= k) continue;
                    
                    // 현재 정점이 낮인 상태여야 하며, 현재 벽을 부순 횟수가 최대보다 더 작은 경우
                    if(c.d){
                        broken[ny][nx] = c.w+1;
                        // Queue에 삽입
                        q.offer(new Pos(ny, nx, c.w+1, c.m+1, false));
                    // 만약 현재 정점이 밤인 상태라면, 낮이 될 때를 대기하여 기다린다.
                    } else {
                        q.offer(new Pos(c.y, c.x, c.w, c.m+1, true));
                    }
                // 벽이 아니라면
                } else {
                    // 부순 벽의 횟수 업데이트
                    broken[ny][nx] = c.w;
                    
                    // 다음 탐색 지점의 낮/밤 여부 지정
                    boolean day = c.d ? false : true;
                    q.offer(new Pos(ny, nx, c.w, c.m+1, day));
                }
            }
        }
        return -1;
    }
}

class Pos{
    int y; // 행 위치
    int x; // 열 위치
    int w; // 부순 벽의 수
    int m; // 이동 횟수
    boolean d; // 낮 밤 여부
    public Pos(int y, int x, int w, int m, boolean d){
        this.y=y;
        this.x=x;
        this.w=w;
        this.m=m;
        this.d=d;
    }
}