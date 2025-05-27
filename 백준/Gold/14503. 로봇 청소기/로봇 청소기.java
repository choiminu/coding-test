import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int row;
    static int col;

    // 북 동 남 서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        row = Integer.parseInt(token.nextToken());
        col = Integer.parseInt(token.nextToken());
        map = new int[row][col];

        token = new StringTokenizer(br.readLine());

        int cx = Integer.parseInt(token.nextToken());
        int cy = Integer.parseInt(token.nextToken());
        int cd = Integer.parseInt(token.nextToken());

        for (int i = 0; i < row; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int bfs = bfs(cy, cx, cd);

        bw.write(bfs + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs(int x, int y, int direction) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, direction});

        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cd = cur[2];

            if (map[cy][cx] == 0) {
                map[cy][cx] = -1;
                cnt++;
            }

            boolean cleanedNearby = false;

            int nd = cd;
            for (int d = 0; d < 4; d++) {
                nd = (nd + 3) % 4;
                int nx = cx + dx[nd];
                int ny = cy + dy[nd];

                // 맵을 벗어나면 건너뛴다.
                if (nx < 0 || ny < 0 || nx >= col || ny >= row) continue;

                // 청소할 수 있는 빈칸이 존재하면 flag true
                if (map[ny][nx] == 0) {
                    queue.offer(new int[]{nx, ny, nd});
                    cleanedNearby = true;
                    break;
                }
            }

            if (!cleanedNearby) {
                int backX = cx - dx[cd];
                int backY = cy - dy[cd];

                // 후진 불가 시 종료
                if (backX < 0 || backY < 0 || backX >= col || backY >= row || map[backY][backX] == 1) {
                    return cnt;
                }

                queue.offer(new int[]{backX, backY, cd});
            }
        }

        return cnt;
    }


}