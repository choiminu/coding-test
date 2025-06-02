import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] eggs;
    static int max;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        eggs = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(token.nextToken());
            eggs[i][1] = Integer.parseInt(token.nextToken());
        }

        dfs(0);

        bw.write(max + "");

        br.close();
        bw.flush();
        br.close();
    }



    public static void dfs(int index) {

        if (index == N) {
            int broken = 0;
            for (int i = 0; i < N; i++) {
                if (eggs[i][0] <= 0) broken++;
            }
            max = Math.max(max, broken);
            return;
        }

        if (eggs[index][0] <= 0) {
            dfs(index + 1);
            return;
        }

        boolean didHit = false;

        for (int i = 0; i < N; i++) {

            if (i == index || eggs[i][0] <= 0) continue;

            didHit = true;

            // 계란끼리 충돌
            eggs[index][0] -= eggs[i][1];
            eggs[i][0] -= eggs[index][1];

            dfs(index + 1);

            // 상태 복구
            eggs[index][0] += eggs[i][1];
            eggs[i][0] += eggs[index][1];

        }

        if (!didHit) {
            dfs(index + 1);
        }

    }
}
