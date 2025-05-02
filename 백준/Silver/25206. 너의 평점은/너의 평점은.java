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

        String[] ratings = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        double[] scores = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};

        double totalRaging = 0.0;
        double totalScore = 0.0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            
            token.nextToken();
            double score = Double.parseDouble(token.nextToken());
            String rating = token.nextToken();

            if (rating.equals("P")) {
                continue;
            }

            totalRaging += score;

            int index = 0;

            for (int j = 0; j < ratings.length; j++) {
                if (rating.equals(ratings[j])) {
                    index = j;
                    break;
                }
            }

            totalScore += scores[index] * score;
        }

        bw.write(totalScore / totalRaging + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
