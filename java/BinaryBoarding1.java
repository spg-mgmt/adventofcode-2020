package year2020.day5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BinaryBoarding1
{
    public static void main(String[] args) throws IOException
    {
        int highestId = -1;
        File file = new File("C:\\Users\\mysti\\Documents\\Projects\\adventofcode\\src\\year2020\\day5\\input.txt");
        FileInputStream fis = new FileInputStream(file);
        Scanner sc = new Scanner(fis);

        while (sc.hasNext())
        {
            String s = sc.nextLine();
            s = s.replace("F", "0");
            s = s.replace("B", "1");
            s = s.replace("L", "0");
            s = s.replace("R", "1");

            int row = Integer.parseInt(s.substring(0,7), 2);
            int col = Integer.parseInt(s.substring(7), 2);

            int seatId = ( row * 8 ) + col;
            if (seatId > highestId)
            {
                highestId = seatId;
            }
        }
        System.out.println(highestId);
    }
}
