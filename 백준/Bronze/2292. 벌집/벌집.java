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
        int range = 2;

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int cnt = 1;
        while (range <= N) {
            range = range + (6 * cnt);
            cnt ++;
        }

        System.out.println(cnt);

        br.close();
        bw.flush();
        bw.close();
    }
}
