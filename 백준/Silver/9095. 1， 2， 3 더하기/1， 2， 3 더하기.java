import java.io.*;

public class Main {

    static int[] nums = {1,2,3};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            result = 0;
            int target = Integer.parseInt(br.readLine());
            backtracking(0, target);
            System.out.println(result);
        }

    }

    public static void backtracking(int n, int target) {
        if (n == target) {
            result++;
            return;
        }

        if (n > target) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            backtracking(n + nums[i], target);
        }
    }
}
