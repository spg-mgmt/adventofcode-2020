package year2020.day1;

import java.util.HashSet;
import java.util.Scanner;

public class ReportRepair2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> set = new HashSet<Integer>();

        while(sc.hasNext())
        {
            int a = sc.nextInt();
            int b = 2020 - a;
            for (int c : set)
            {
                if (set.contains(b - c))
                {
                    System.out.println("\n" + (a * c * (b - c)));
                    System.out.println("Numbers are : " + a + ", " + c + ", " + (b - c));
                    break;
                }
            }
            set.add(a);
        }
    }
}
