import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = null;

        while ((input = br.readLine()) != null) {

            int small = 0;
            int big = 0;
            int digit = 0;
            int space = 0;

            for (char ch : input.toCharArray()) {
                if (Character.isLowerCase(ch)) small++;
                if (Character.isUpperCase(ch)) big++;
                if (Character.isDigit(ch)) digit++;
                if (Character.isSpaceChar(ch)) space++;
            }

            bw.write(small + " " + big + " " + digit + " " + space + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}


