import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n,m;
    static char[][] map;
    static int[][] fireTime;
    static int[][] userTime;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<int[]> fireQueue = new LinkedList<>();
    static Queue<int[]> userQueue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        map = new char[n][m];
        fireTime = new int[n][m];
        userTime = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j];
                fireTime[i][j] = -1;
                userTime[i][j] = -1;

                if (input[j] == 'J') {
                    userQueue.offer(new int[]{i,j});
                    userTime[i][j] = 0;
                }

                if (input[j] == 'F') {
                    fireQueue.offer(new int[]{i,j});
                    fireTime[i][j] = 0;
                }
            }
        }


        while (!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == '#' || fireTime[nx][ny] != -1) continue;

                fireTime[nx][ny] = fireTime[x][y] + 1;
                fireQueue.offer(new int[]{nx, ny});
            }
        }


        while (!userQueue.isEmpty()) {
            int[] cur = userQueue.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == 0 || y == 0 || x == n - 1 || y == m - 1) {
                System.out.println(userTime[x][y] + 1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == '#' || userTime[nx][ny] != -1) continue;
                if (fireTime[nx][ny] != -1 && fireTime[nx][ny] - 1 <= userTime[x][y]) continue;

                userTime[nx][ny] = userTime[x][y] + 1;
                userQueue.offer(new int[]{nx, ny});
            }
        }

        System.out.println("IMPOSSIBLE");

    }
}