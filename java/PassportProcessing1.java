package year2020.day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class PassportProcessing1
{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\mysti\\Documents\\Projects\\adventofcode\\src\\year2020\\day4\\input.txt");
        FileInputStream fis = new FileInputStream(file);
        Scanner sc = new Scanner(fis);
        HashMap<String, String> attributes = new HashMap<>();
        int validPassports = 0;
        while (sc.hasNext())
        {
            String line = sc.nextLine().trim();
            if (line.equals(""))
            {
                attributes.clear();
                continue;
            }

            String[] lineArray = line.split(" ");
            for (String s : lineArray)
            {
                String[] keyValue = s.split(":");
                attributes.put(keyValue[0], keyValue[1]);
            }

            if (attributes.size() == 8 || (attributes.size() == 7 && !attributes.containsKey("cid")))
            {
                validPassports += 1;
                attributes.clear();
            }
        }

        System.out.println("\nNumber of valid passwords are : " + validPassports);
    }
}
