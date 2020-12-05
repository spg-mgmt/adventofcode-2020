package year2020.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TobogganTrajectory2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int l = line.length();
        int curr1 = 0, curr2 = 0, curr3 = 0, curr4 = 0, curr5 = 0;
        int lineNo = 0;
        int treeCount1 = 0;
        int treeCount2 = 0;
        int treeCount3 = 0;
        int treeCount4 = 0;
        int treeCount5 = 0;
        while ((line = br.readLine()) != null)
        {
            lineNo += 1;
            if (line.equals(""))
            {
                break;
            }

            curr1 = (curr1 + 1) % l;
            char c1 = line.charAt(curr1);
            if (c1 == '#')
            {
                treeCount1 += 1;
            }

            curr2 = (curr2 + 3) % l;
            char c2 = line.charAt(curr2);
            if (c2 == '#')
            {
                treeCount2 += 1;
            }

            curr3 = (curr3 + 5) % l;
            char c3 = line.charAt(curr3);
            if (c3 == '#')
            {
                treeCount3 += 1;
            }

            curr4 = (curr4 + 7) % l;
            char c4 = line.charAt(curr4);
            if (c4 == '#')
            {
                treeCount4 += 1;
            }

            if (lineNo % 2 == 0)
            {
                curr5 = (curr5 + 1) % l;
                char c5 = line.charAt(curr5);
                if (c5 == '#')
                {
                    treeCount5 += 1;
                }
            }
        }
        int treeProduct = treeCount1 * treeCount2 * treeCount3 * treeCount4 * treeCount5;
        System.out.println(treeCount1 + " " + treeCount2 + " " + treeCount3 + " " + treeCount4 + " " + treeCount5);
        System.out.println("\n" + treeProduct);
    }
}
