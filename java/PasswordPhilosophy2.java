package year2020.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordPhilosophy2
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
            int checkpoint1 = Integer.parseInt(limits[0]);
            int checkpoint2 = Integer.parseInt(limits[1]);
            char givenLetter = lineContent[1].charAt(0);
            String password = lineContent[2];

            boolean isValid = false;
            if (password.charAt(checkpoint1 - 1) == givenLetter)
            {
                isValid = !isValid;
            }
            if (password.charAt(checkpoint2 - 1) == givenLetter)
            {
                isValid = !isValid;
            }

            if (isValid)
            {
                validPasswords += 1;
            }
        }

        System.out.println("\n" + validPasswords);
    }
}
