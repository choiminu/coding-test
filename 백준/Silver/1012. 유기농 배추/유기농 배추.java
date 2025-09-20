import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int COL, ROW;
    static int[][] map;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 사용자에게 테스트 케이스의 개수를 입력받는다.
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {

            // 사용자에게 배추밭의 크기와 배추의 개수를 입력받는다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            COL = Integer.parseInt(st.nextToken());
            ROW = Integer.parseInt(st.nextToken());
            int seed = Integer.parseInt(st.nextToken());

            // 입력받은 크기를 바탕으로 맵과 방문여부 배열을 초기화
            map = new int[ROW][COL];
            isVisited = new boolean[ROW][COL];

            // 사용자에게 배추의 위치를 입력받고 map에 반영
            for (int i = 0; i < seed; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int result = 0;
            for (int y = 0; y < ROW; y++) {
                for (int x = 0; x < COL; x++) {
                    if (map[y][x] == 1 && !isVisited[y][x]) {
                        result++;
                        bfs(x,y);
                    }
                }
            }

            System.out.println(result);

        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= COL || ny >= ROW) continue;
                if (map[ny][nx] != 1 || isVisited[ny][nx]) continue;

                isVisited[ny][nx] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}

