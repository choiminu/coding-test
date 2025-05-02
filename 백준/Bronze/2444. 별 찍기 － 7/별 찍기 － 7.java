import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {

            for (int j = 0; j < N - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }


        for (int i = 1; i <= N; i++) {

            if (i == 1) continue;

            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = N * 2; j > i * 2 - 1; j--) {
                System.out.print("*");
            }

            System.out.println();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
