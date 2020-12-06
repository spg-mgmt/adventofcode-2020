package year2020.day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PassportProcessing2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        HashSet<String> colors = new HashSet<>();
        colors.add("amb");
        colors.add("blu");
        colors.add("brn");
        colors.add("gry");
        colors.add("grn");
        colors.add("hzl");
        colors.add("oth");

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
            try
            {
                String[] lineArray = line.split(" ");
                for (String s : lineArray)
                {
                    String[] keyValue = s.split(":");
                    attributes.put(keyValue[0], keyValue[1]);
                }

                if (attributes.size() == 8 || (attributes.size() == 7 && !attributes.containsKey("cid")))
                {
                    //add data verification
                    boolean isValid;

                    //validate byr
                    isValid = isYearValid(attributes.get("byr"), 1920, 2002);
                    if (!isValid)
                    {
                        attributes.clear();
                        continue;
                    }
                    System.out.println("works so far: byr");
                    //validate iyr
                    isValid = isYearValid(attributes.get("iyr"), 2010, 2020);
                    if (!isValid)
                    {
                        attributes.clear();
                        continue;
                    }
                    System.out.println("works so far: iyr");
                    //validate eyr
                    isValid = isYearValid(attributes.get("eyr"), 2020, 2030);
                    if (!isValid)
                    {
                        attributes.clear();
                        continue;
                    }
                    System.out.println("works so far: eyr");

                    //validate hgt
                    String height = attributes.get("hgt");
                    int heightLength = height.length();
                    int hgt = Integer.parseInt(height.substring(0, heightLength - 2));
                    if (height.substring(heightLength-2).equals("in"))
                    {
                        System.out.println("works so far: hgt inches");
                        if (hgt < 59 || hgt > 76)
                        {
                            attributes.clear();
                            continue; //we directly continue to next loop since its invalid
                        }
                    }
                    else if (height.substring(heightLength-2).equals("cm"))
                    {
                        System.out.println("works so far: hgt cms");
                        if (hgt < 150 || hgt > 193)
                        {
                            attributes.clear();
                            continue;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid height format !!!!!!!");
                        attributes.clear();
                        continue;
                    }
                    System.out.println("works so far: hgt");

                    //validte hair color
                    if (!Pattern.matches("^#([0-9a-f]{6})$", attributes.get("hcl")))
                    {
                        attributes.clear();
                        continue;
                    }
                    System.out.println("works so far: hcl");

                    //validate eye color
                    System.out.println("eye color is : " + attributes.get("ecl"));
                    if (!colors.contains(attributes.get("ecl")))
                    {
                        attributes.clear();
                        continue;
                    }
                    System.out.println("works so far: eye colors");
                    //validate pid
                    if (!Pattern.matches("[0-9]{9}", attributes.get("pid")))
                    {
                        attributes.clear();
                        continue;
                    }
                    System.out.println("works so far: pid" + attributes.get("pid"));
                    validPassports += 1;
                    attributes.clear();
                }
            }
            catch (Exception e)
            {
                attributes.clear();
            }

        }

        System.out.println("\nNumber of valid passwords are : " + validPassports);
    }

    //method to validate year fields in passport
    private static boolean isYearValid(String s, int start, int end)
    {
        if (s.length() == 4)
        {
            try
            {
                int year = Integer.parseInt(s);
                if (year >= start && year <= end)
                {
                    return true;
                }
            }
            catch (Exception e)
            {
                return false;
            }
        }
        return false;
    }
}

