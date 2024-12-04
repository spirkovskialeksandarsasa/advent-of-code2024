package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Advent4dvojka {
    public static void main(String[] args) throws IOException {

        String path = "Advent2024/day4/input4.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<char[]> matrica = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            matrica.add(line.toCharArray());
        }
        System.out.println(findWord(matrica));
    }

    public static int findWord(List<char[]> matrica) {
        int total = 0;
        int rows = matrica.size();
        int cols = matrica.get(0).length;

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (matrica.get(i)[j] == 'A' &&
                        (
                                (i - 1 >= 0 && j - 1 >= 0 && i + 1 < rows && j + 1 < cols &&
                                        ((matrica.get(i - 1)[j - 1] == 'S' && matrica.get(i + 1)[j + 1] == 'M') ||
                                                (matrica.get(i - 1)[j - 1] == 'M' && matrica.get(i + 1)[j + 1] == 'S'))
                                ) &&
                                        (i + 1 < rows && j - 1 >= 0 && i - 1 >= 0 && j + 1 < cols &&
                                                ((matrica.get(i + 1)[j - 1] == 'S' && matrica.get(i - 1)[j + 1] == 'M') ||
                                                        (matrica.get(i + 1)[j - 1] == 'M' && matrica.get(i - 1)[j + 1] == 'S'))
                                        )
                        )
                ) {
                    total++;
                }
            }
        }

        return total;
    }
}