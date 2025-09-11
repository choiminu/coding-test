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

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight  = Integer.parseInt(st.nextToken());
            int height  = Integer.parseInt(st.nextToken());
            arr[i][0] = weight;
            arr[i][1] = height;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int lank = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i != j &&arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    lank++;
                }
            }
            sb.append(lank).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

