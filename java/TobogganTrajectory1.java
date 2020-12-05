package year2020.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TobogganTrajectory1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int l = line.length();
        int curr = 0;
        int treeCount = 0;
        while ((line = br.readLine()) != null)
        {
            if (line.equals(""))
            {
                break;
            }
            curr = (curr + 3) % l;
            char c = line.charAt(curr);
            if (c == '#')
            {
                treeCount += 1;
            }
        }
        System.out.println("\n" + treeCount);
    }
}
