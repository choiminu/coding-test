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

        String line;
        while ((line = br.readLine()) != null) {

            StringTokenizer token = new StringTokenizer(line);
            while (token.hasMoreTokens()) {
                int answer = 0;
                int start = Integer.parseInt(token.nextToken());
                int end = Integer.parseInt(token.nextToken());

                for (; start <= end; start++) {
                    int[] arr = new int[10];
                    boolean flag = true;

                    int temp = start;
                    while (temp > 0) {
                        int num = temp % 10;

                        if (arr[num] != 0) {
                            flag = false;
                            break;
                        }

                        arr[num]++;
                        temp = temp / 10;
                    }

                    if (flag) {
                        answer++;
                    }
                }
                System.out.println(answer);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }


}