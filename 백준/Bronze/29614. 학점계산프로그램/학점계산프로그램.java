import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Double> score = new HashMap<>();
        score.put('A', 4.0);
        score.put('B', 3.0);
        score.put('C', 2.0);
        score.put('D', 1.0);
        score.put('F', 0.0);

        String input = br.readLine();

        int total = 0;
        double sum = 0.0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                sum += score.get(input.charAt(i));
                total++;
            } else {
                sum += 0.5;
            }
        }

        System.out.println(sum / total);


        br.close();
    }

}

