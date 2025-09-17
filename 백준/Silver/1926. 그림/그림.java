import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int ROW,COL;
    static int[][] map;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0,0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        map = new int[ROW][COL];
        isVisited = new boolean[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COL; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxArea = 0;
        int count = 0;

        for (int y = 0; y < ROW; y++) {
            for (int x = 0; x < COL; x++) {
                if (map[y][x] == 1 && !isVisited[y][x]) {
                    maxArea = Math.max(maxArea, bfs(x, y));
                    count++;
                }
            }
        }

        System.out.println(count + "\n" + maxArea);

        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        isVisited[y][x] = true;

        int count = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= COL || ny >= ROW) continue;
                if (map[ny][nx] != 1 || isVisited[ny][nx]) continue;

                isVisited[ny][nx] = true;
                q.offer(new int[]{nx, ny});
                count++;
            }
        }

        return count;
    }
}

