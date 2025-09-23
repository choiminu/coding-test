import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] A = new int[N][N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N+1];
        dp[0][0] = A[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {

                if (j == 0) {
//                    dp[i][j] = Math.max(A[i][j] + dp[i-1][j], A[i][j] + dp[i-1][j+1]);
                    dp[i][j] = A[i][j] + dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(A[i][j] + dp[i-1][j-1], A[i][j] + dp[i-1][j]);
                }

            }
        }

        int result = Arrays.stream(dp)
                .flatMap(i -> Arrays.stream(i).boxed()).mapToInt(i -> i).max().getAsInt();

        System.out.println(result);

        br.close();
        bw.flush();
        bw.close();
    }
}
