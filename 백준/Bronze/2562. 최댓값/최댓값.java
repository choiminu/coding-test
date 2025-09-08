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

        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < 9; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value > maxValue) {
                maxValue = value;
                maxIndex = i + 1;
            }
        }

        bw.write(maxValue + "\n" + maxIndex);

        br.close();
        bw.flush();
        bw.close();
    }
}

