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

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] scores = new int[N];
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());

            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }

        double result = 0.0;
        for (int score : scores) {
            result += (double) score / maxScore * 100;
        }

        bw.write(result / N + "");

        br.close();
        bw.flush();
        bw.close();
    }
}

