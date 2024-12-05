package day5;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Advent5 {
    public static void main(String[] args) throws IOException {

        String path = "Advent2024/day5/input5.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<Tuple2<Integer, Integer>> tuples = br.lines()
                .takeWhile(line -> !line.trim().isEmpty())
                .map(line -> line.split("\\|"))
                .map(parts -> Tuple.of(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim())))
                .toList();

        List<Integer[]> pages = br.lines()
                .map(line -> line.split(","))
                .map(parts -> Arrays.stream(parts)
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new))
                .toList();

        int middle;
        int total = 0;

        for (Integer[] page : pages)
            if (checkOrder(page, tuples)) {
                middle = page[page.length / 2];
                total += middle;
            }
        System.out.println(total);
    }

    public static boolean isItBefore(Tuple2<Integer, Integer> tuple, List<Tuple2<Integer, Integer>> tuples) {
        int tuple1 = tuple._1;
        int tuple2 = tuple._2;
        for (Tuple2<Integer, Integer> pair : tuples) {
            if (pair._1 == tuple1 && pair._2 == tuple2) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkOrder(Integer[] pages, List<Tuple2<Integer, Integer>> tuples) {
        for (int i = 0; i < pages.length - 1; i++) {
            for (int j = i + 1; j < pages.length; j++) {
                Tuple2<Integer, Integer> tuple = Tuple.of(pages[i], pages[j]);
                if (!isItBefore(tuple, tuples)) {
                    return false;
                }
            }
        }
        return true;
    }
}
