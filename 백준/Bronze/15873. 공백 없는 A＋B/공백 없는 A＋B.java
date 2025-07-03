import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int total = 0;
		
		if(a / 10 <= 10) {
			total += a / 10;
			if(a % 10 == 0) {
				total += 10;
			}else {
				total += a % 10;
			}
		}else {
			total += a / 100;
			if(a % 10 == 0) {
				total += 10;
			}else {
				total += a % 10;
			}
		}
		
		System.out.println(total);
		sc.close();
	}
}