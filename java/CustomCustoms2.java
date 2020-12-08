package year2020.day6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomCustoms2
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("C:\\Users\\mysti\\Documents\\Projects\\adventofcode\\src\\year2020\\day6\\input.txt");
        FileInputStream fis = new FileInputStream(file);
        Scanner sc = new Scanner(fis);

        HashMap<Character, Integer> groupAnswers = new HashMap<>();
        int lineCount = 0;
        int similarAnswerCount = 0;
        int prevCount = 0;
        int totalAnswers = 0;

        while (sc.hasNext())
        {
            String line = sc.nextLine().trim();

            if (line.equals(""))
            {
                groupAnswers.clear();
                lineCount = 0; //no of ppl
                prevCount = 0;
                continue;
            }
            lineCount += 1;
            for (int i = 0; i < line.length(); i++)
            {
                char a = line.charAt(i);
                if (groupAnswers.containsKey(a))
                {
                    groupAnswers.put(a, groupAnswers.get(a) + 1);
                }
                else
                {
                    groupAnswers.put(a, 1);
                }
            }
            similarAnswerCount = 0;
            //iterate through hashmap and check all entries that have same frequency as lineCount
            for (Map.Entry e: groupAnswers.entrySet())
            {
                if ((int) e.getValue() == lineCount)
                {
                    similarAnswerCount += 1;
                }
            }
            if (lineCount == 1)
            {
                totalAnswers += similarAnswerCount;
            }
            if (prevCount > similarAnswerCount)
            {
                totalAnswers -= prevCount - similarAnswerCount;
            }
            prevCount = similarAnswerCount;
        }

        System.out.println(totalAnswers);
    }
}
