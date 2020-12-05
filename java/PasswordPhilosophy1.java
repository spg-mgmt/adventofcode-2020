package year2020.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordPhilosophy1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        int validPasswords = 0;
        while ((line = br.readLine()) != null)
        {
            if (line.equals(""))
            {
                break;
            }
            String[] lineContent = line.split(" ");
            String[] limits = lineContent[0].split("-");
            int lowerLimit = Integer.parseInt(limits[0]);
            int upperLimit = Integer.parseInt(limits[1]);
            char givenLetter = lineContent[1].charAt(0);
            String password = lineContent[2];
            int count = 0;
            for (int i = 0; i < password.length(); i++)
            {
                if (password.charAt(i) == givenLetter)
                {
                    count += 1;
                }
            }
            if (count >= lowerLimit && count <= upperLimit)
            {
                validPasswords += 1;
            }
        }

        System.out.println("\n" + validPasswords);
    }
}
