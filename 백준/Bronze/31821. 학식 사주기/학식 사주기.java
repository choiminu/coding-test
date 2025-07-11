import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int [] menuCost = new int [num+1];
        int totalCost = 0;

        for (int i = 1; i <= num; i++) {
            menuCost[i] = Integer.parseInt(br.readLine());
        }

        int student = Integer.parseInt(br.readLine());

        for (int i = 0; i < student; i++) {
            int studentChoice = Integer.parseInt(br.readLine());

            totalCost += menuCost[studentChoice];
        }

        sb.append(totalCost);
        System.out.println(sb.toString());

    }
}