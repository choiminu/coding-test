import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(token.nextToken());
        int y = Integer.parseInt(token.nextToken());

        int gcd = getGcd(x, y);

        System.out.println(gcd);
        System.out.println(gcd * (x / gcd) * (y / gcd));

    }

    public static int getGcd(int x, int y) {
        if (y == 0) return x;
        return getGcd(y, x % y);
    }
}