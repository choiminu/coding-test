import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int L = Integer.parseInt(token.nextToken());

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int[] A = new int[3];
            boolean valid = true;
            int sum = 0;

            for (int j = 0; j < 3; j++) {
                A[j] = Integer.parseInt(token.nextToken());
                if (A[j] < L) {
                    valid = false;
                }
                sum += A[j];
            }

            if (valid && sum >= K) {
                cnt++;
                for (int s : A) {
                    sb.append(s).append(" ");
                }
            }
        }

        bw.write(cnt + "\n" + sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
