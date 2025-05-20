import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int N;
    static int[][] map;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        N = n;
        map = computers;
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }

        return answer;
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next = 0; next < N; next++) {
                if (map[cur][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
