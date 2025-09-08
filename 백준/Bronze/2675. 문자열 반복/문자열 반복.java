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

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int reap = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for (int i = 0; i < str.length(); i++) {
                sb.append(String.valueOf(str.charAt(i)).repeat(reap));
            }
            sb.append("\n");
            bw.write(sb.toString());
        }


        br.close();
        bw.flush();
        bw.close();
    }
}

