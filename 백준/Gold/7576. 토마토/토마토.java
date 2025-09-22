import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int ROW, COL;
    static int[][] map;

    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        COL = Integer.parseInt(st.nextToken());
        ROW = Integer.parseInt(st.nextToken());

        map = new int[ROW][COL];

        for (int y = 0; y < ROW; y++){
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < COL; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 1) queue.offer(new int[]{x, y});
            }
        }

        bfs();

        int max = 0;
        boolean flag = false;

        for (int[] ints : map) {
            if (flag) {
                break;
            }
            for (int anInt : ints) {
                if (anInt == 0)  {
                    flag = true;
                    break;
                }
                max = Math.max(max, anInt);
            }
        }

        System.out.println(flag ? -1 : max - 1);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d= 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= COL || ny >= ROW) continue;
                if (map[ny][nx] != 0) continue;

                map[ny][nx] = map[cy][cx] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}

