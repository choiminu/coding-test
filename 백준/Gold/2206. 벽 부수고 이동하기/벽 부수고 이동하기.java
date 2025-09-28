import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int ROW, COL;
    static int[][] map;
    static boolean[][][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        map = new int[ROW][COL];
        isVisited = new boolean[ROW][COL][2];

        for (int y = 0; y < ROW; y++) {
            char[] temp = br.readLine().toCharArray();
            for (int x = 0; x < COL; x++) {
                map[y][x] = temp[x] - '0';
            }
        }

        int result = bfs();

        System.out.println(result);

        br.close();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1, 0});
        isVisited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int time = cur[2];
            int broken = cur[3];

            if (cx == COL - 1 && cy == ROW - 1) {
                return time;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= COL || ny >= ROW) continue;

                if (isVisited[ny][nx][broken]) continue;

                if (map[ny][nx] == 1) {
                    if (broken == 0) {
                        isVisited[ny][nx][1] = true;
                        queue.offer(new int[]{nx, ny, time + 1, 1});
                    }
                    continue;
                }

                isVisited[ny][nx][broken] = true;
                queue.offer(new int[]{nx, ny, time + 1, broken});
            }
        }

        return -1;
    }
}
