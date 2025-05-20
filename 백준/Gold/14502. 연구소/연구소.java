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
    static int M;
    static int maxSafeArea;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static int[][] copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];

        for (int row = 0; row < N; row++) {
            token = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                map[row][col] = Integer.parseInt(token.nextToken());
            }
        }

        createWall(0);

        System.out.println(maxSafeArea);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void createWall(int wallCount) {
        if (wallCount == 3) {
            spreading();
            return;
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (map[row][col] == 0) {
                    map[row][col] = 1;
                    createWall(wallCount + 1);
                    map[row][col] = 0;
                }
            }
        }
    }

    public static void spreading() {
        Queue<int[]> queue = new LinkedList<>();

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (map[row][col] == 2) {
                    queue.offer(new int[]{col, row});
                }
            }
        }

        for (int row = 0; row < N; row++) {
            copyMap[row] = map[row].clone();
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || ny >= N || nx >= M) {
                    continue;
                }
                if (copyMap[ny][nx] != 0) {
                    continue;
                }

                queue.offer(new int[]{nx, ny});
                copyMap[ny][nx] = 2;
            }
        }

        findASafetyArea(copyMap);
    }

    public static void findASafetyArea(int[][] copyMap) {
        int safeAres = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (copyMap[row][col] == 0) {
                    safeAres++;
                }
            }
        }
        maxSafeArea = Math.max(maxSafeArea, safeAres);
    }


}