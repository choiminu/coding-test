import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int tc = Integer.parseInt(br.readLine());
        while (tc --> 0) {

            int clothes = Integer.parseInt(br.readLine());

            Map<String, List<String>> have = new HashMap<>();
            for (int i = 0; i < clothes; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());

                String name = token.nextToken();
                String type = token.nextToken();

                have.putIfAbsent(type, new ArrayList<>());
                have.get(type).add(name);
            }

            int answer = 1;

            for (String key : have.keySet()) {
                answer *= (have.get(key).size() + 1); 
            }

            answer -= 1; 

            System.out.println(answer);

        }

        br.close();
        bw.flush();
        bw.close();

    }
}