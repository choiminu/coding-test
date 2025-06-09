import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            String[] input = br.readLine().split(" ");
            for (String str : input) {
                for (int i = str.length() - 1; i >= 0; i--) {
                    bw.write(str.charAt(i));
                }
                bw.write(" ");
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
