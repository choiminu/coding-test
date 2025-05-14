import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int color;
    static int[][] map;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        color = 1;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for (int y = 0; y < N; y++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(token.nextToken());
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 1 && !isVisited[y][x]) {
                    segregation(x, y);
                    color++;
                }
            }
        }

        bw.write(bfs()+"");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void segregation(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        isVisited[y][x] = true;
        map[y][x] = color;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N & ny < N) {
                    if (map[ny][nx] == 1 && !isVisited[ny][nx]) {
                        queue.offer(new int[]{nx, ny});
                        isVisited[ny][nx] = true;
                        map[ny][nx] = color;
                    }
                }
            }
        }
    }

    private static int bfs() {
        int min = Integer.MAX_VALUE;

        for (int c = 1; c < color; c++) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] isVisited = new boolean[N][N];
            int[][] distance = new int[N][N];

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (map[y][x] == c) {
                        queue.offer(new int[]{x, y});
                        isVisited[y][x] = true;
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int cx = cur[0];
                int cy = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && !isVisited[ny][nx]) {
                        if (map[ny][nx] != 0 && map[ny][nx] != c) {
                            min = Math.min(min, distance[cy][cx]);
                            break;
                        }

                        if (map[ny][nx] == 0) {
                            isVisited[ny][nx] = true;
                            distance[ny][nx] = distance[cy][cx] + 1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return min;
    }
}

