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

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        Map<String, String> pwList = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] siteMap = br.readLine().split(" ");

            String site = siteMap[0];
            String password = siteMap[1];

            pwList.put(site, password);
        }

        for (int i = 0; i < M; i++) {
            String site = br.readLine();
            bw.write(pwList.get(site)+"\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }
}

