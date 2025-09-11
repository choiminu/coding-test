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

        int[][] members = new int[N][2];
        String[] names = new String[N];
        for (int i = 0; i < members.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members[i][0] = Integer.parseInt(st.nextToken());
            members[i][1] = i;
            names[i] = st.nextToken();
        }

        Arrays.sort(members,(m1, m2) -> {
            if (m1[0] == m2[0]) {
                return Integer.compare(m1[1], m2[1]);
            }
            return Integer.compare(m1[0], m2[0]);
        });

        StringBuilder sb = new StringBuilder();
        for (int[] member : members) {
            sb.append(member[0]).append(" ").append(names[member[1]]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

