package year2020.day1;

import java.util.HashSet;
import java.util.Scanner;

public class ReportRepair1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> set = new HashSet<Integer>();

        while (sc.hasNext())
        {
            int a = sc.nextInt();
            if (set.contains(2020 - a))
            {
                System.out.println("\n" +  a * (2020 - a));
                break;
            }
            else
            {
                set.add(a);
            }
        }
    }
}
