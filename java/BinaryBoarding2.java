package year2020.day5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinaryBoarding2
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("C:\\Users\\mysti\\Documents\\Projects\\adventofcode\\src\\year2020\\day5\\input.txt");
        FileInputStream fis = new FileInputStream(file);
        Scanner sc = new Scanner(fis);

        //since values arent sorted we record highest and lowest values
        int highestId = -1;
        int lowestId = 1025;  //128 * 8 = 1024
        int sum = 0;
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
            sum += seatId;

            if ( seatId > highestId)
            {
                highestId = seatId;
            }
            if ( seatId < lowestId )
            {
                lowestId = seatId;
            }
        }
        //sum of all values from x - y
        //is same as sum of all first y natural nos - sum of all first x-1 natural nos

        int expectedSum = ((highestId * (highestId + 1)) / 2) - ((lowestId * (lowestId - 1)) / 2);
        int mySeatId = expectedSum - sum;
        System.out.println("Seat no is : " + mySeatId);
    }
}
