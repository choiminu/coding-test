import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int g = sc.nextInt();
		int p = sc.nextInt();
		int t = sc.nextInt();
		int total1 = g * p;
		int total2 = t * p + g;
		
		if(total1 < total2) {
			System.out.println("1");
		}else if(total1 > total2) {
			System.out.println("2");
		}else if(total1 == total2) {
			System.out.println("0");
		}
		sc.close();
	}
}