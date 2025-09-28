import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int X, Y, Z;

    static char[][][] map;
    static boolean[][][] isVisited;

    static Queue<int[]> player;

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Z = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            if (Z == 0 && Y == 0 && X == 0) {
                break;
            }

            player = new LinkedList<>();
            map = new char[Z][Y][X];
            isVisited = new boolean[Z][Y][X];

            for (int z = 0; z < Z; z++) {
                for (int y = 0; y < Y; y++) {
                    char[] temp = br.readLine().toCharArray();
                    for (int x = 0; x < X; x++) {
                        map[z][y][x] = temp[x];
                        if (map[z][y][x] == 'S') {
                            player.offer(new int[]{x, y, z, 0});
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs();

            if (result == -1) {
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in " + result + " minute(s).\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }


    public static int bfs() {
        while (!player.isEmpty()) {
            int[] cur = player.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cz = cur[2];
            int time = cur[3];

            if (map[cz][cy][cx] == 'E') {
                return time;
            }

            for (int d = 0; d < 6; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                int nz = cz + dz[d];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= X || ny >= Y || nz >= Z) {
                    continue;
                }
                if (map[nz][ny][nx] == '#' || isVisited[nz][ny][nx]) {
                    continue;
                }

                isVisited[nz][ny][nx] = true;
                player.offer(new int[]{nx, ny, nz, time + 1});
            }
        }

        return -1;
    }


}
