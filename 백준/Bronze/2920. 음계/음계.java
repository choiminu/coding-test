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

        String[] result = {"ascending", "descending", "mixed"};

        StringTokenizer st = new StringTokenizer(br.readLine());

        int prev = -9;
        int index = 2;

        while (st.hasMoreTokens()) {
            int cur = Integer.parseInt(st.nextToken());

            if (prev == -9) {
                prev = cur;
                continue;
            }

            if (prev + 1 == cur) {
                index = 0;
            } else if (prev - 1 == cur) {
                index = 1;
            } else {
                index = 2;
                break;
            }

            prev = cur;
        }

        bw.write(result[index]);

        br.close();
        bw.flush();
        bw.close();
    }
}

