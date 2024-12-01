package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Advent1dvojka {
    public static void main(String[] args) throws FileNotFoundException {
        int total = 1;
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


        System.out.println(calculateSimilarity(arr1, arr2));
    }

    public static int calculateSimilarity(int[] array1, int[] array2) {
        int similarity = 0;
        int count = 0;
        for(int i=0;i<array1.length;i++){
            for(int j=0;j<array2.length;j++){
                if(array1[i]==array2[j]) {
                    count++;
                }
            }
            similarity+= array1[i] * count;
            count =0;
        }
        return similarity;
    }
}