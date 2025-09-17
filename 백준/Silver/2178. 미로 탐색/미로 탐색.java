import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int X, Y;
    static int[][] map;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[Y][X];
        isVisited = new boolean[Y][X];

        for (int y = 0; y < Y; y++) {
            String input = br.readLine();
            for (int x = 0; x < X; x++) {
                map[y][x] = input.charAt(x) - '0';
            }
        }

        int result = bfs();

        System.out.println(result);

        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // x, y, dist
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if (cx == X - 1 && cy == Y - 1) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= X || ny >= Y) {
                    continue;
                }

                if (map[ny][nx] == 0 || isVisited[ny][nx]) {
                    continue;
                }

                isVisited[ny][nx] = true;
                queue.offer(new int[] {nx, ny, dist + 1});
            }
        }
        return -1;
    }
}

