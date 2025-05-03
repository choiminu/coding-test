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

        int N = Integer.parseInt(br.readLine());

        Object[][] arr = new Object[N][2];

        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, (a,b) -> {
            if (a[0] == b[0]) return 0;
            return Integer.compare(Integer.parseInt(String.valueOf(a[0])), Integer.parseInt(String.valueOf((b[0]))));
        });

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }

}
