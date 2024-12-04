package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Advent4 {
    public static void main(String[] args) throws IOException {

        String path = "Advent2024/day4/input4.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<char[]> matrica = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            matrica.add(line.toCharArray());
        }

        String word = "XMAS";
        System.out.print(findWord(matrica, word));
    }

    // .size = redica
    //.get0.len = kol
    public static boolean directionalSearch(List<char[]> matrica, String word, int x, int y, int dx, int dy) {
        int rows = matrica.size();
        int cols = matrica.get(0).length;

        for (int i = 0; i < word.length(); i++) {
            int nx = x + i * dx;
            int ny = y + i * dy;

            if (nx < 0 || nx >= rows || ny < 0 || ny >= cols || matrica.get(nx)[ny] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static int findWord(List<char[]> matrica, String word) {
        int total = 0;
        int rows = matrica.size();
        int cols = matrica.get(0).length;

        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        // l, r, u, d, ul, dl, ur, dr

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrica.get(i)[j] == word.charAt(0)) {
                    for (int d = 0; d < 8; d++) {
                        if (directionalSearch(matrica, word, i, j, dx[d], dy[d])) {
                            total++;
                        }
                    }
                }
            }
        }

        return total;
    }
}
