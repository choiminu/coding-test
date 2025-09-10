import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int index = input.indexOf('*');

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (i == index) continue;
            int temp = input.charAt(i) - '0';
            if (i % 2 != 0) {
                sum += temp * 3;
            } else {
                sum += temp;
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            if (index % 2 == 0) {
                if ((sum + i) % 10 == 0) {
                    answer = i;
                }
            }else {
                if((sum + i * 3) % 10 == 0) {
                    answer = i;
                }
            }
        }

        System.out.println(answer);

        br.close();
        bw.flush();
        bw.close();
    }


}

