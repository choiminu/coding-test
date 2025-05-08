import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {

    static int L;
    static int R;
    static int C;
    static int minTime = 99;

    static char[][][] building;
    static boolean[][][] isVisited;

    static Queue<int[]> queue;

    // 동 서 남 북 상 하
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            L = Integer.parseInt(token.nextToken());
            R = Integer.parseInt(token.nextToken());
            C = Integer.parseInt(token.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            building = new char[L][R][C];
            isVisited = new boolean[L][R][C];
            queue = new LinkedList<>();

            for (int z = 0; z < L; z++) {
                for (int y = 0; y < R; y++) {
                    char[] input = br.readLine().toCharArray();
                    for (int x = 0; x < C; x++) {
                        building[z][y][x] = input[x];
                        if (input[x] == 'S') {
                            queue.offer(new int[]{x, y, z, 0});
                        }
                    }
                }
                br.readLine();
            }

            int time = bfs();

            if (time != -1) {
                System.out.println("Escaped in "+ time +" minute(s).");
            } else {
                System.out.println("Trapped!");
            }

        }

    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cz = cur[2];
            int time = cur[3];

            if (building[cz][cy][cx] == 'E') {
                return time;
            }

            for (int d = 0; d < 6; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                int nz = cz + dz[d];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < C && ny < R && nz < L) {
                    if (building[nz][ny][nx] != '#' && !isVisited[nz][ny][nx]) {
                        queue.offer(new int[]{nx, ny, nz, time + 1});
                        isVisited[nz][ny][nx] = true;
                    }
                }
            }
        }
        return -1;
    }
}

