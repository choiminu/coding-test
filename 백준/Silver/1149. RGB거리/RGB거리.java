import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사용자에게 집의 개수를 입력받는다.
        int N = Integer.parseInt(br.readLine());

        // 각 집에 페인트 비용을 저장하는 배열선언.
        int[][] P = new int[N][3];

        // 사용자에게 각 집의 페인트 비용을 입력받아 배열에 저장한다.
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            P[i][0] = Integer.parseInt(st.nextToken());
            P[i][1] = Integer.parseInt(st.nextToken());
            P[i][2] = Integer.parseInt(st.nextToken());
        }

        // 각 집에 칠할 수 있는 페인트의 최소 비용
        int[][] dp = new int[N][3];
        dp[0][0] = P[0][0];
        dp[0][1] = P[0][1];
        dp[0][2] = P[0][2];

        for (int i = 1; i < N; i++) {
            // i번째 집을 빨강으로 칠하는 경우에는 i-1번째 집은 G, B 색이어야 한다.
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + P[i][0];
            // i번째 집을 초록로 칠하는 경우에는 i-1번째 집은 R, B 색이어야 한다.
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + P[i][1];
            // i번째 집을 파랑으로 칠하는 경우에는 i-1번째 집은 R, G 색이어야 한다.
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + P[i][2];
        }

        System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));

        br.close();
        bw.flush();
        bw.close();
    }
}

