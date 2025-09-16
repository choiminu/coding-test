import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class Main {

    static Predicate<String> isDigit = str -> Character.isDigit(str.charAt(0));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] idToName = new String[N + 1];
        Map<String, Integer> nameToId = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            idToName[i] = name;
            nameToId.put(name, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String value = br.readLine();

            if (isDigit.test(value)) {
                sb.append(idToName[Integer.parseInt(value)]).append("\n");
            } else {
                sb.append(nameToId.get(value)).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

