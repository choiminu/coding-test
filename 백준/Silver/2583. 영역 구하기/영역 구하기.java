import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int ROW, COL;
    static int[][] map;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new int[ROW][COL];
        isVisited = new boolean[ROW][COL];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        int count = 0;
        List<Integer> sizes = new ArrayList<>();

        for (int y = 0; y < ROW; y++) {
            for (int x = 0; x < COL; x++) {
                if (map[y][x] == 0 && !isVisited[y][x]) {
                    count++;
                    sizes.add(bfs(x,y));
                }
            }
        }

        System.out.println(count);
        sizes.stream().sorted().mapToInt(i -> i).forEach(i -> System.out.print(i + " "));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs (int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        isVisited[y][x] = true;

        int size = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= COL || ny >= ROW) continue;
                if (map[ny][nx] != 0 || isVisited[ny][nx]) continue;

                isVisited[ny][nx] = true;
                queue.offer(new int[] {nx, ny});
                size++;
            }
        }

        return size;
    }

}

