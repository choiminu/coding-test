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

        int[] index = new int[26];
        Arrays.fill(index, -1);

        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            int idx = input[i] - 'a';
            if (index[idx] == -1) {
                index[idx] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : index) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

