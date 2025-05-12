import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int result = 0;
        while (token.hasMoreTokens()) {
            result += (int) Math.pow(Integer.parseInt(token.nextToken()), 2);
        }

        bw.write(result % 10 +"");

        br.close();
        bw.flush();
        bw.close();

    }

}

