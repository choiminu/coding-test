import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[][] map;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (min > map[i][j]) min = map[i][j];
                if (max < map[i][j]) max = map[i][j];
            }
        }

        int maxArea = 0;
        for (int i = 0; i <= max; i++) {
            isVisited = new boolean[N][N];
            int count = 0;
            drowning(i);

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (map[y][x] != -1 && !isVisited[y][x]) {
                        count++;
                        bfs(x,y);
                    }
                }
            }
            maxArea = Math.max(maxArea, count);
        }

        System.out.println(maxArea);

        br.close();
        bw.flush();
        bw.close();
    }


    public static void drowning(int height) {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] <= height) {
                    map[y][x] = -1;
                }
            }
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[ny][nx] == -1 || isVisited[ny][nx]) continue;

                isVisited[ny][nx] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
    }




}

