import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(token.nextToken());
            cost[i][1] = Integer.parseInt(token.nextToken());
            cost[i][2] = Integer.parseInt(token.nextToken());
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }


        int result = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N-1][2]));

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();

    }
}
