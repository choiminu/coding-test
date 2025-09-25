import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int X,Y,Z;
    static int[][][] box;

    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        box = new int[Z][Y][X];

        for (int z = 0; z < Z; z++) {
            for (int y = 0; y < Y; y++) {
                String[] input = br.readLine().split(" ");
                for (int x = 0; x < X; x++) {
                    box[z][y][x] = Integer.parseInt(input[x]);
                    if (box[z][y][x] == 1) {
                        queue.offer(new int[]{x, y, z, 1});
                    }
                }
            }
        }

        bfs();
        
        int max = 0;
        for (int[][] ints : box) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    if (i == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, i);
                }
            }
        }

        System.out.println(max-1);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cz = cur[2];
            int time = cur[3];

            for (int d = 0; d < 6; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                int nz = cz + dz[d];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= X || ny >= Y || nz >= Z) continue;
                if (box[nz][ny][nx] != 0) continue;

                box[nz][ny][nx] = time + 1;
                queue.offer(new int[]{nx, ny, nz, time + 1});
            }
        }
    }

}
