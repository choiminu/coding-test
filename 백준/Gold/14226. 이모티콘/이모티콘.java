import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[2001][2001];

        int bfs = bfs();
        System.out.println(bfs);

        br.close();
        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0, 0});
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int screen = cur[0];
            int clip = cur[1];
            int time = cur[2];

            if (screen == N) {
                return time;
            }

            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if (!visited[screen][screen]) {
                queue.offer(new int[]{screen, screen, time + 1});
                visited[screen][screen] = true;
            }

            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (clip > 0 && screen + clip < 2000 && !visited[screen + clip][clip]) {
                queue.offer(new int[]{screen + clip, clip, time + 1});
                visited[screen + clip][clip] = true;
            }

            // 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (screen - 1 >= 0 && !visited[screen - 1][clip]) {
                visited[screen - 1][clip] = true;
                queue.offer(new int[]{screen - 1, clip, time + 1});
            }
        }

        return -1;

    }

}
