import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] card = new int[20];
        for (int i = 0; i < card.length; i++) {
            card[i] = i + 1;
        }

        for (int i = 0; i < 10; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(token.nextToken()) - 1;
            int end = Integer.parseInt(token.nextToken()) - 1;

            while (start < end) {
                int temp = card[start];
                card[start] = card[end];
                card[end] = temp;

                start++;
                end--;
            }
        }

        for (int i : card) {
            bw.write(i + " ");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
