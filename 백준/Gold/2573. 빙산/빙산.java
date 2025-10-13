import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int C, L;

    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[L][C];

        for (int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int year = 0;

        while (true) {
            int count = countIcebergs();

            if (count == 0) {
                year = 0;
                break;
            }

            if (count >= 2) {
                break;
            }

            melt();
            year++;
        }

        System.out.println(year);

        br.close();
        bw.flush();
        br.close();
    }

    public static void melt() {
        int[][] copyMap = new int[L][C];

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < C; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int y = 0; y < L; y++) {
            for (int x = 0; x < C; x++) {
                if (map[y][x] > 0) {
                    int sea = 0;

                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];

                        if (ny < 0 || nx < 0 || ny >= L || nx >= C) continue;
                        if (map[ny][nx] == 0) sea++;
                    }

                    copyMap[y][x] = Math.max(0, map[y][x] - sea);
                }
            }
        }

        map = copyMap;
    }

    public static int countIcebergs() {
        boolean[][] visited = new boolean[L][C];
        int count = 0;

        for (int y = 0; y < L; y++) {
            for (int x = 0; x < C; x++) {
                if (map[y][x] > 0 && !visited[y][x]) {
                    bfs(x, y, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public static void bfs(int x, int y, boolean[][] isVisited) {
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

                if (nx < 0 || ny < 0 || nx >= C || ny >= L) {
                    continue;
                }
                if (isVisited[ny][nx] || map[ny][nx] == 0) {
                    continue;
                }

                isVisited[ny][nx] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

}
