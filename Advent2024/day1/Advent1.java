package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Advent1 {
    public static void main(String[] args) throws FileNotFoundException {
        int total = 0;

        String path = "Advent2024/day1/input1.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            list1.add(Integer.parseInt(parts[0]));
            list2.add(Integer.parseInt(parts[1]));
        }

        int[] arr1 = list1.stream().mapToInt(Integer::intValue).toArray();
        int[] arr2 = list2.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            total += Math.abs(arr1[i] - arr2[i]);
        }

        System.out.println(total);
    }
}

