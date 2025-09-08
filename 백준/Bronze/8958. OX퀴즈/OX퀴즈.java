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

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int totalScore = 0;
            int score = 1;

            char[] res = br.readLine().toCharArray();
            for (char ch : res) {
                if (ch == 'O') {
                    totalScore += score++;
                } else {
                    score = 1;
                }
            }

            bw.write(totalScore + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

