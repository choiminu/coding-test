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

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int num = Integer.parseInt(br.readLine());

            if (Math.abs(num) % 2 == 0) {
                bw.write(num + " is even\n");
            } else {
                bw.write(num + " is odd\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}