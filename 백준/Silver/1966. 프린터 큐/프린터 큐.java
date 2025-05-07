import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(token.nextToken());
            int target = Integer.parseInt(token.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            token = new StringTokenizer(br.readLine());

            for (int j = 0; j < size; j++) {
                queue.offer(new int[]{Integer.parseInt(token.nextToken()), j});
            }

            int printOrder = 0;
            while (!queue.isEmpty()) {
                int[] front = queue.poll();

                boolean hasHighPriority = false;

                for (int[] q : queue) {
                    if (q[0] > front[0]) {
                        hasHighPriority = true;
                        break;
                    }
                }

                if (hasHighPriority) {
                    queue.offer(front);
                } else {
                    printOrder++;
                    if (front[1] == target) {
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }
    }

}

