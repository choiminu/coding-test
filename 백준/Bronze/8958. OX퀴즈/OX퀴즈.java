import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();

            int sum = 0;
            int score = 0;
            for (char c : input) {
                if (c == 'O') {
                    score++;
                    sum += score;
                } else {
                    score = 0;
                }
            }

            bw.write(sum + "\n");

        }

        br.close();
        bw.flush();
        bw.close();

    }

}

