import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = new String[4];
        int[] nums = new int[4];

        int index = -1;
        int num = 0;

        for (int i = 0; i < 3; i++) {
            arr[i] = br.readLine();

            if (arr[i].charAt(0) >= '0' && arr[i].charAt(0) <= '9') {
                index = i;
                num = Integer.parseInt(arr[i]);
            }
        }


        int count = 0;
        for (int i = index; i < nums.length; i++, count++) {
            nums[i] = num + count;
        }

        if (nums[3] % 3 == 0 && nums[3] % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (nums[3] % 3 == 0) {
            System.out.println("Fizz");
        } else if (nums[3] % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(nums[3]);
        }
    }
}
