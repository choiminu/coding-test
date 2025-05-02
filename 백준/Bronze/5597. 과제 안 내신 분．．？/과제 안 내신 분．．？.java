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

        boolean[] st = new boolean[30];

        for (int i = 0; i < 28; i++) {
            st[Integer.parseInt(br.readLine()) - 1] = true;
        }

        for (int i = 0; i < st.length; i++) {
            if (!st[i]) {
                bw.write(i + 1 + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
