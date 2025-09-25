import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int ROW, COL;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            COL = Integer.parseInt(st.nextToken());
            ROW = Integer.parseInt(st.nextToken());

            char[][] map = new char[ROW][COL];
            int[][] fireTime = new int[ROW][COL]; // 불이 도달하는 시간
            boolean[][] visited = new boolean[ROW][COL]; // 플레이어 방문 여부

            Queue<int[]> fireQueue = new LinkedList<>();
            Queue<int[]> playerQueue = new LinkedList<>();

            // 초기화
            for (int y = 0; y < ROW; y++) {
                String line = br.readLine();
                for (int x = 0; x < COL; x++) {
                    map[y][x] = line.charAt(x);
                    fireTime[y][x] = Integer.MAX_VALUE; // 불이 아직 도달하지 않은 상태

                    if (map[y][x] == '*') {
                        fireQueue.offer(new int[]{x, y, 0}); // 불 초기 위치, 시간 0
                        fireTime[y][x] = 0;
                    }

                    if (map[y][x] == '@') {
                        playerQueue.offer(new int[]{x, y, 0}); // 플레이어 초기 위치, 시간 0
                        visited[y][x] = true;
                    }
                }
            }

            // 불 확산 BFS
            while (!fireQueue.isEmpty()) {
                int[] cur = fireQueue.poll();
                int cx = cur[0], cy = cur[1], time = cur[2];

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (nx < 0 || ny < 0 || nx >= COL || ny >= ROW) continue;
                    if (map[ny][nx] == '#' || fireTime[ny][nx] <= time + 1) continue;

                    fireTime[ny][nx] = time + 1;
                    fireQueue.offer(new int[]{nx, ny, time + 1});
                }
            }

            // 플레이어 BFS
            int result = -1;
            while (!playerQueue.isEmpty()) {
                int[] cur = playerQueue.poll();
                int cx = cur[0], cy = cur[1], time = cur[2];

                // 가장자리 도착 시 탈출 가능
                if (cx == 0 || cy == 0 || cx == COL - 1 || cy == ROW - 1) {
                    result = time + 1;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (nx < 0 || ny < 0 || nx >= COL || ny >= ROW) continue;
                    if (visited[ny][nx] || map[ny][nx] == '#') continue;
                    if (time + 1 >= fireTime[ny][nx]) continue; // 불보다 먼저 도착해야 함

                    visited[ny][nx] = true;
                    playerQueue.offer(new int[]{nx, ny, time + 1});
                }
            }

            if (result == -1) {
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(result + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
