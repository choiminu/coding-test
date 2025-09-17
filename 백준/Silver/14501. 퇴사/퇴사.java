import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사용자에게 남은 N일을 입력받는다.
        int N = Integer.parseInt(br.readLine());

        // 상담 시간을 저장할 배열 선언
        int[] times = new int[N + 2];

        // 상담 비용을 저장할 배열 선언
        int[] pay = new int[N + 2];

        // 1부터 N까지 순회하며 사용자에게 입력받은 상딤시간과 비용을 배열에 저장한다.
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        // N 일에서 얻을 수 있는 최대 수익을 보관할 배열 선언
        int[] dp = new int[N + 2];

        for (int i = N; i >= 1; i--) {

            // 오늘날짜에서 상담을 끝낸 다음 시작할 날짜
            int next = i + times[i];

            // 상담을 끝낸 날짜가 N보다 크거나 작은 경우는 상담이 가능하다.
            if (next <= N + 1) {
                dp[i] = Math.max(pay[i] + dp[times[i] + i], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);

        br.close();
        bw.flush();
        bw.close();
    }


}

