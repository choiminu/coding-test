import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> list = new ArrayList<int[]>();
        
        int n = sc.nextInt();
        int sum = 2;
        int cnt = 0;
        
        while(cnt<n)
        {
            for(int i=sum-1; i>0; i--)
            {
                list.add(new int[]{i, sum-i});
                cnt++;
            }
            
            sum++;
        }
        
        System.out.println(list.get(n-1)[0] + " " + list.get(n-1)[1]);
        sc.close();
    }
}