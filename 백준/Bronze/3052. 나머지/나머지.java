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

        boolean[] remain = new boolean[42];

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int value = Integer.parseInt(br.readLine());
            int r = value % 42;

            if (!remain[r]) {
                sum++;
            }

            remain[r] = true;
        }

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}

