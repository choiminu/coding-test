import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {

            for (int j = 1; j < i; j++) {
                bw.write(" ");
            }

            for (int j = 1; j <= N * 2 - (i * 2 - 1); j++) {
                bw.write("*");
            }

            bw.write("\n");
        }



        bw.flush();
        bw.close();
        br.close();
    }
}
