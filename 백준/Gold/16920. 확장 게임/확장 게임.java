import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int row;
    static int col;
    static int P;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static int[] playerDistance;
    static int[] result;

    static Queue<int[]>[] queues;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        row = Integer.parseInt(token.nextToken());
        col = Integer.parseInt(token.nextToken());
        P = Integer.parseInt(token.nextToken());

        map = new int[row][col];
        playerDistance = new int[P + 1];
        queues = new ArrayDeque[P + 1];
        result = new int[P + 1];

        for (int i = 1; i <= P; i++) {
            queues[i] = new ArrayDeque<>();
        }

        token = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            playerDistance[i] = Integer.parseInt(token.nextToken());
        }

        for (int y = 0; y < row; y++) {
            char[] input = br.readLine().toCharArray();
            for (int x = 0; x < col; x++) {
                if (input[x] == '.') {
                    map[y][x] = 0;
                } else if (input[x] == '#') {
                    map[y][x] = -1;
                } else {
                    map[y][x] = input[x] - '0';
                    queues[input[x] - '0'].offer(new int[] {x, y});
                    result[input[x] - '0']++;
                }
            }
        }

        bfs();

        for (int i = 1; i < result.length; i++) {
            bw.write(result[i] + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs() {
        while (true) {
            boolean expanded = false;
            for (int p = 1; p <= P; p++) {
                Queue<int[]> currentQueue = queues[p];
                for (int step = 1; step <= playerDistance[p]; step++) {
                    int size = currentQueue.size();

                    if (size == 0) {
                        break;
                    }

                    for (int i = 0; i < size; i++) {
                        int[] cur = currentQueue.poll();
                        int cx = cur[0];
                        int cy = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = cx + dx[d];
                            int ny = cy + dy[d];

                            if (nx < 0 || ny < 0 || nx >= col || ny >= row) continue;
                            if (map[ny][nx] != 0) continue;

                            result[p]++;
                            map[ny][nx] = p;
                            currentQueue.offer(new int[]{nx, ny});
                            expanded = true;
                        }
                    }
                }
            }
            if (!expanded) {
                break;
            }
        }

    }


}