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

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = (int)Math.pow(Integer.parseInt(st.nextToken()),2);
            int B = (int)Math.pow(Integer.parseInt(st.nextToken()),2);
            int C = (int)Math.pow(Integer.parseInt(st.nextToken()),2);

            if (A == 0 && B == 0 && C == 0) {
                break;
            }

            int max = Math.max(Math.max(A,B), Math.max(A,C));

            if (A + B + C - max == max) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }

        }

        br.close();
        bw.flush();
        bw.close();
    }
}

