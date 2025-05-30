import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] A;
    static int[] R;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        A = new int[N];
        R = new int[M];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(A);

        dfs(0, 0);

        bw.write(sb.toString());


        br.close();
        bw.flush();
        br.close();
    }

    public static void dfs(int start, int depth) {
        if (depth == M) {
            for (int val : R) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            R[depth] = A[i];
            dfs(i, depth + 1);
        }

    }
}
