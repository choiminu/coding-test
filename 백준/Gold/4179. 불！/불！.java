import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int X, Y;

    static char[][] map;
    static boolean[][] isVisited;
    static int[][] fireTime;

    static Queue<int[]> player = new LinkedList<>();
    static Queue<int[]> fire = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new char[Y][X];
        isVisited = new boolean[Y][X];
        fireTime = new int[Y][X];

        for (int y = 0; y < Y; y++) {
            char[] temp = br.readLine().toCharArray();
            for (int x = 0; x < X; x++) {
                map[y][x] = temp[x];
                fireTime[y][x] = -1;

                if (temp[x] == 'F') {
                    fire.offer(new int[]{x, y, 0});
                    fireTime[y][x] = 0;
                }

                if (temp[x] == 'J') {
                    player.offer(new int[]{x, y, 0});
                }
            }
        }

        bfsFire();
        int result = bfsPlayer();

        if (result == -1) {
            bw.write("IMPOSSIBLE\n");
        } else {
            bw.write(result+"");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfsFire() {
        while (!fire.isEmpty()) {
            int[] cur = fire.poll();
            int cx = cur[0];
            int cy = cur[1];
            int time = cur[2];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= X || ny >= Y) {
                    continue;
                }

                if (map[ny][nx] == '#' || fireTime[ny][nx] != -1) {
                    continue;
                }

                fireTime[ny][nx] = time + 1;
                fire.offer(new int[]{nx, ny, time + 1});
            }
        }
    }

    public static int bfsPlayer() {
        while (!player.isEmpty()) {
            int[] cur = player.poll();
            int cx = cur[0];
            int cy = cur[1];
            int time = cur[2];
            isVisited[cy][cx] = true;

            if (cx == 0 || cy == 0 || cx + 1 == X || cy + 1 == Y) {
                return time + 1;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= X || ny >= Y) {
                    continue;
                }

                if (map[ny][nx] == '#' || isVisited[ny][nx]) {
                    continue;
                }

                if (fireTime[ny][nx] != -1 && fireTime[ny][nx] <= time + 1) {
                    continue;
                }

                isVisited[ny][nx] = true;
                player.offer(new int[]{nx, ny, time + 1});
            }
        }

        return -1;
    }

}
