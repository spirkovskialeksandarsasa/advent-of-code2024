package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Advent2 {

    public static void main(String[] args) throws FileNotFoundException {
        int total = 0;

        String path = "Advent2024/day2/input2.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int[] arrays = Arrays.stream(parts)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (checkReportSafety(arrays)) {
                total++;
            } else if (checkPart2(arrays)) {
                total++;
            }
        }
        System.out.println(total);

    }

    public static boolean check1(int[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            int razlika = arrays[i] - arrays[i + 1];
            if (arrays[i] <= arrays[i + 1]) {
                return false;
            }
            if (Math.abs(razlika) < 1 || Math.abs(razlika) > 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean check2(int[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            int razlika = arrays[i] - arrays[i + 1];
            if (arrays[i] >= arrays[i + 1]) {
                return false;
            }
            if (Math.abs(razlika) < 1 || Math.abs(razlika) > 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkReportSafety(int[] arrays) {
        return check2(arrays) || check1(arrays);
    }

    public static boolean checkPart2(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int[] tajp6it = new int[arrays.length - 1];
            for (int j = 0, k = 0; j < arrays.length; j++) {
                if (j == i) {
                    continue;
                }
                tajp6it[k++] = arrays[j];
            }
            if (checkReportSafety(tajp6it)) {
                return true;
            }
        }
        return false;
    }
}