import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static int[] A;
    static int result;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        A = new int[N];
        isVisited = new boolean[N];

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        dfs(0, 0);

        if (M == 0) result -= 1;

        bw.write(result + "");

        br.close();
        bw.flush();
        br.close();
    }

    public static void dfs(int depth, int sum) {

        if (depth == N) {
            if (sum == M) {
                result++;
            }
            return;
        }

        dfs(depth + 1, sum + A[depth]);
        dfs(depth + 1, sum);

    }
}
