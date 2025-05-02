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

        String[] dail = {"","", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", ""};
        char[] input = br.readLine().toCharArray();

        int result = 0;
        for (char ch : input) {

            for (int i = 0; i < dail.length; i++) {
                if (dail[i].contains(String.valueOf(ch))) {
                    result += i;
                }
            }
        }

        bw.write(result+"");


        br.close();
        bw.flush();
        bw.close();
    }
}
