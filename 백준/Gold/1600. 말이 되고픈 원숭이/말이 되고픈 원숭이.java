import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int K;
    static int W;
    static int H;

    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {-1, 1, 0, 0, -2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {0, 0, -1, 1, -1, -2, -2, -1, 1, 2, 2, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());
        W = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int y = 0; y < H; y++) {
            token = new StringTokenizer(br.readLine());
            for (int x = 0; x < W; x++) {
                map[y][x] = Integer.parseInt(token.nextToken());
            }
        }

        System.out.println(bfs());

//        for (int[] a : map) {
//            for (int b : a) {
//                System.out.print(b + " ");
//            }
//            System.out.println();
//        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0}); // x, y, horse, distance
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int horse = cur[2];
            int distance = cur[3];

            if (cx == W - 1 && cy == H - 1) {
                return distance;
            }

            for (int d = 0; d < 12; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < W && ny < H) {

                    if (map[ny][nx] != 1 && !visited[ny][nx][horse] && d < 4) {
                        queue.offer(new int[]{nx, ny, horse, distance + 1});
                        visited[ny][nx][horse] = true;
                    }

                    if (d >= 4 && horse < K && map[ny][nx] != 1 && !visited[ny][nx][horse + 1]) {
                        queue.offer(new int[]{nx, ny, horse + 1, distance + 1});
                        visited[ny][nx][horse + 1] = true;
                    }
                }

            }
        }
        return -1;
    }


}

