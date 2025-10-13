import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int color = -1;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 1 && !isVisited[y][x]) {
                    segregation(x, y, color);
                    color--;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        isVisited = new boolean[N][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] != 0 && !isVisited[y][x]) {
                    result = Math.min(result, bfs(map[y][x]));
                }
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
        br.close();
    }

    public static void segregation(int x, int y, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        map[y][x] = color;
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (map[ny][nx] == 0 || isVisited[ny][nx]) {
                    continue;
                }

                isVisited[ny][nx] = true;
                map[ny][nx] = color;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    public static int bfs(int color) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        // 섬 경계만 큐에 넣기
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == color) {
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (map[ny][nx] == 0) { // 물 칸
                            queue.offer(new int[]{nx, ny, 1});
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1], dist = cur[2];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d], ny = cy + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[ny][nx]) continue;

                if (map[ny][nx] != 0 && map[ny][nx] != color) {
                    return dist;
                }

                if (map[ny][nx] == 0) {
                    queue.offer(new int[]{nx, ny, dist + 1});
                    visited[ny][nx] = true;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

}

