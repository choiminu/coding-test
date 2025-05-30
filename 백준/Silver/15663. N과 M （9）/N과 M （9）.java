import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static int[] A;
    static int[] R;
    static boolean[] isVisited;

    static LinkedHashSet<String> result = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        A = new int[N];
        R = new int[M];
        isVisited = new boolean[N];

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(A);

        dfs(0);

        for (String seq : result) {
            bw.write(seq);
        }

        br.close();
        bw.flush();
        br.close();
    }

    public static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int val : R) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                R[depth] = A[i];
                dfs(depth + 1);
                isVisited[i] = false;
            }
        }

    }
}
