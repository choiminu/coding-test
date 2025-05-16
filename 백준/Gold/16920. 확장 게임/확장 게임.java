import java.io.*;
import java.util.*;

public class Main {

    static int row, col, P;
    static int[] playerDistance;
    static int[][] map;
    static int[] result;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<int[]>[] playerQueues;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        row = Integer.parseInt(token.nextToken());
        col = Integer.parseInt(token.nextToken());
        P = Integer.parseInt(token.nextToken());

        playerDistance = new int[P + 1];
        result = new int[P + 1];
        playerQueues = new ArrayDeque[P + 1];
        for (int i = 1; i <= P; i++) {
            playerQueues[i] = new ArrayDeque<>();
        }

        token = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            playerDistance[i] = Integer.parseInt(token.nextToken());
        }

        map = new int[row][col];
        for (int y = 0; y < row; y++) {
            char[] line = br.readLine().toCharArray();
            for (int x = 0; x < col; x++) {
                char c = line[x];
                if (c == '#') {
                    map[y][x] = -1; // 벽
                } else if (c == '.') {
                    map[y][x] = 0; // 빈 칸
                } else {
                    int player = c - '0';
                    map[y][x] = player;
                    playerQueues[player].offer(new int[]{x, y});
                    result[player]++;
                }
            }
        }

        // 게임 루프
        while (true) {
            boolean expanded = false;

            for (int p = 1; p <= P; p++) {
                int move = playerDistance[p];
                Queue<int[]> currentQueue = playerQueues[p];

                for (int step = 0; step < move; step++) {
                    int size = currentQueue.size();
                    if (size == 0) break;

                    for (int i = 0; i < size; i++) {
                        int[] cur = currentQueue.poll();
                        int x = cur[0], y = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx < 0 || ny < 0 || nx >= col || ny >= row) continue;
                            if (map[ny][nx] != 0) continue;

                            map[ny][nx] = p;
                            result[p]++;
                            currentQueue.offer(new int[]{nx, ny});
                            expanded = true;
                        }
                    }
                }
            }

            if (!expanded) break;
        }

        for (int i = 1; i <= P; i++) {
            bw.write(result[i] + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
