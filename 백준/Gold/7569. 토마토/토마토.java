import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N, M, L;

    static int[][][] box;
    static boolean[][][] isVisited;

    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static int[] dz = {-1, 1, 0, 0, 0, 0};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        L = Integer.parseInt(token.nextToken());

        box = new int[L][M][N];
        isVisited = new boolean[L][M][N];

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < M; j++) {
                token = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    box[i][j][k] = Integer.parseInt(token.nextToken());
                }
            }
        }

        for (int z = 0; z < L; z++) {
            for (int y = 0; y < M; y++) {
                for (int x = 0; x < N; x++) {
                    if (box[z][y][x] == 1) {
                        queue.offer(new int[]{x, y, z});
                        isVisited[z][y][x] = true;
                    }
                }
            }
        }

        bfs();

        boolean hasZero = false;
        int maxDay = 0;

        for (int[][] layer : box) {
            for (int[] arr : layer) {
                for (int num : arr) {
                    if (maxDay < num) {
                        maxDay = num;
                    }

                    if (num == 0) {
                        hasZero = true;
                        break;
                    }
                }
            }
        }

        if (hasZero) {
            System.out.println(-1);
        } else {
            System.out.println(maxDay - 1);
        }


    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int cx = cur[0];
            int cy = cur[1];
            int cz = cur[2];

            for (int d = 0; d < 6; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                int nz = cz + dz[d];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < L) {
                    if (box[nz][ny][nx] == 0 && !isVisited[nz][ny][nx]){
                        queue.offer(new int[]{nx, ny, nz});
                        isVisited[nz][ny][nx] = true;
                        box[nz][ny][nx] = box[cz][cy][cx] + 1;
                    }
                }
            }
        }

    }
}