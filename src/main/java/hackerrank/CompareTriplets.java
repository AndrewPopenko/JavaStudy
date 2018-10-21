// // https://www.hackerrank.com/challenges/compare-the-triplets/problem
package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareTriplets {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int countA = 0, countB = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < b.get(i)) {
                countB++;
            } else if (a.get(i) > b.get(i)) {
                countA++;
            }
        }

        return Arrays.asList(countA, countB);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String rawString = bufferedReader.readLine().replaceAll("\\s+$", "");
        String[] aItems = rawString.split(" ");

        List<Integer> a = new ArrayList<>();

        for (String str : aItems) {
            a.add(Integer.parseInt(str));
        }

        String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> b = new ArrayList<>();

        for (String str : bItems) {
            b.add(Integer.parseInt(str));
        }

        List<Integer> result = compareTriplets(a, b);

        System.out.println(result.get(0) + " " + result.get(1));

    }
}