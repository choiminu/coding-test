import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer size = new StringTokenizer(br.readLine());
        StringTokenizer bundle = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(bundle.nextToken());
        int P = Integer.parseInt(bundle.nextToken());

        int tshirt = 0;
        while (size.hasMoreTokens()) {
            int s = Integer.parseInt(size.nextToken());
            tshirt += (s + T - 1) / T;
        }

        bw.write(tshirt + "\n");
        bw.write(N / P + " " + N % P);

        br.close();
        bw.flush();
        bw.close();
    }
}

