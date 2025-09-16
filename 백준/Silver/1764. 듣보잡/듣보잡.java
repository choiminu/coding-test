import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            String name = br.readLine();
            if (i < N) {
                map.put(name, 1);
            } else {
                map.put(name, map.getOrDefault(name, 0) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();

        long count = map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .count();

        sb.append(count).append("\n");

        map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> {
                    sb.append(entry.getKey()).append("\n");
                });

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

