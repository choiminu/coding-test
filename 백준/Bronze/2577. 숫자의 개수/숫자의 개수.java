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

        int[] cnt = new int[10];

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        char[] arr = (A * B * C + "").toCharArray();
        for (char ch : arr) {
            cnt[ch - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : cnt) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());


        br.close();
        bw.flush();
        bw.close();
    }
}

