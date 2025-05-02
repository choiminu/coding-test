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

        boolean[] st = new boolean[42];

        for (int i = 0; i < 10; i++) {
            st[Integer.parseInt(br.readLine()) % 42] = true;
        }

        int result = 0;

        for (int i = 0; i < st.length; i++) {
            if (st[i]) {
                result++;
            }
        }

        bw.write(result + "");


        br.close();
        bw.flush();
        bw.close();
    }
}
