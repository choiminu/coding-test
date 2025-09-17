import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사용자에게 테스트 케이스의 개수를 입력받는다.
        int T = Integer.parseInt(br.readLine());

        // 피보나치 수열에서 N번째 위치한 숫자의 0과 1가 등장한 횟수를 저장한다.
        int[][] dp = new int[41][2];

        // 0번째 위치한 값은 0이므로 0의 등장횟수는 1이고 1이 등장한 횟수는 0이다.
        dp[0][0] = 1;
        dp[0][1] = 0;

        // 1번째 위치한 값은 1이므로 0의 등장횟수는 0이고 1이 등장한 횟수는 1이다.
        dp[1][0] = 0;
        dp[1][1] = 1;

        StringBuilder sb = new StringBuilder();
        while (T --> 0) {
            // 사용자에게 정수 N을 입력받는다.
            int N = Integer.parseInt(br.readLine());

            for (int i = 2; i <= N; i++) {
                // i번째 위치한 수열의 0의 개수는 dp[i - 1][0] + dp[i - 2][0] 이다.
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
                // i번째 위치한 수열의 1의 개수는 dp[i - 1][1] + dp[i - 2][1] 이다.
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
            }
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }


}

