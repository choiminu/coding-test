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

        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 1; i <= 9; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N > max) {
                max = N;
                index = i;
            }
        }

        bw.write(max + "\n" + index);

        br.close();
        bw.flush();
        bw.close();
    }
}
