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
            String str = br.readLine();
            int[] result = recursion(str, 0, str.length() - 1, 1);
            bw.write(result[0] + " " + result[1] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int[] recursion (String str, int start, int end, int cnt) {
        if (start >= end) {
            return new int[] {1, cnt};
        } else if (str.charAt(start) != str.charAt(end)) {
            return new int[] {0, cnt};
        } else {
            return recursion(str, start + 1, end -1, cnt + 1);
        }
    }

}