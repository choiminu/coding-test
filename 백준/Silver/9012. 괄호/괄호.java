import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            String input = br.readLine();
            int cnt = 0;

            for (char ch : input.toCharArray()) {
                if (ch == '(') {
                    cnt++;
                } else {
                    if (cnt <= 0) {
                        cnt = -99;
                    }
                    cnt--;
                }
            }

            if (cnt == 0) {
                bw.write("YES\n");
            }else {
                bw.write("NO\n");
            }

        }


        br.close();
        bw.flush();
        bw.close();
    }

}
