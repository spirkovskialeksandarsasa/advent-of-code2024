package day3;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advent3 {
    public static void main(String[] args) throws IOException {
        int total = 0;

        String path = "Advent2024/day3/input3.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line;
        while ((line = reader.readLine()) != null) {
            Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                total += x * y;
            }
        }
        System.out.println(total);
    }
}
