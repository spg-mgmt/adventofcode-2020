package year2020.day6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class CustomCustoms1
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("C:\\Users\\mysti\\Documents\\Projects\\adventofcode\\src\\year2020\\day6\\input.txt");
        FileInputStream fis = new FileInputStream(file);
        Scanner sc = new Scanner(fis);

        int totalCount = 0;
        int prevCount = 0, currCount;
        HashSet<Character> answers = new HashSet<>();

        while (sc.hasNext())
        {
            String line = sc.nextLine().trim();

            if (line.equals(""))
            {
                prevCount = 0;
                answers.clear();
                continue;
            }
            else
            {
                for (int i = 0; i < line.length(); i++)
                {
                    answers.add(line.charAt(i));
                    currCount = answers.size();
                    if (currCount > prevCount)
                    {
                        totalCount += 1;
                        prevCount = currCount;
                    }
                }
            }
        }
        System.out.println(totalCount);
    }
}
