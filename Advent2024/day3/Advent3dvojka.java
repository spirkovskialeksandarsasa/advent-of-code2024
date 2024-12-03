package day3;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advent3dvojka {
    public static void main(String[] args) throws IOException {
        int total = 0;
        boolean flag = true;

        String path = "Advent2024/day3/input3.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line;
        while ((line = reader.readLine()) != null) {
            Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String match = matcher.group();
                if (match.equals("do()")) {
                    flag = true;
                } else if (match.equals("don't()")) {
                    flag = false;
                } else if ((flag == true) && match.startsWith("mul(")) {
                    int x = Integer.parseInt(matcher.group(1));
                    int y = Integer.parseInt(matcher.group(2));
                    total += x * y;
                }
            }
        }
        System.out.println(total);
    }
}
