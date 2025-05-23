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


        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer input = new StringTokenizer(br.readLine());

        st.nextToken();

        int target = Integer.parseInt(st.nextToken());

        while (input.hasMoreTokens()) {
            int n = Integer.parseInt(input.nextToken());
            if (n < target) {
                bw.write(n + " ");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
