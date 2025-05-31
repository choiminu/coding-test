import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A;
    static int[] R;
    static boolean[] isVisited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());

            if (N == 0) break;

            A = new int[N];
            R = new int[6];
            isVisited = new boolean[N];

            for (int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(token.nextToken());
            }

            dfs(0, 0);

            sb.append("\n");

        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        br.close();
    }

    public static void dfs(int start, int depth) {

        if (depth == 6) {
            for (int i : R) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                R[depth] = A[i];
                dfs(i, depth + 1);
                isVisited[i] = false;
            }
        }

    }

}
