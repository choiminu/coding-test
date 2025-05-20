import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean flag = false;

            bw.write("Pairs for " + num + ": ");
            for (int j = 1; j <= num / 2; j++) {

                if (j == (num - j)) {
                    continue;
                }

                if (j + (num - j) == num) {
                    if (flag) {
                        bw.write(", " + j + " "  + (num - j));
                    } else {
                        bw.write(j + " "  + (num - j));
                        flag = true;
                    }
                }
            }

            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}