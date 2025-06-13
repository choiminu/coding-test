import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] score = new int[N + 1];  // 각 계단의 점수 (1번부터 사용)
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];  // dp[i] = i번째 계단까지의 최대 점수

        if (N >= 1) dp[1] = score[1];
        if (N >= 2) dp[2] = score[1] + score[2];
        if (N >= 3) dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(
                dp[i - 2] + score[i],                         // 한 칸 건너뛰기
                dp[i - 3] + score[i - 1] + score[i]          // 연속 두 칸 밟기 (그 전에 쉬어야 함)
            );
        }

        System.out.println(dp[N]); // 마지막 계단은 반드시 밟아야 하므로 dp[N]
    }
}
