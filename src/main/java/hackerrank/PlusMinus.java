// https://www.hackerrank.com/challenges/plus-minus/problem
package hackerrank;

import java.util.Scanner;

public class PlusMinus {
    private static int n;
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        plusMinus(arr);

    }

    private static void plusMinus(int[] arr) {
        double positive = 0, negative = 0, zero = 0;
        for (int item : arr) {
            if (item == 0) {
                ++zero;
            } else if ((item < 0)) {
                ++negative;
            } else {
                ++positive;
            }
        }

        System.out.printf("%6f\n", positive/arr.length);
        System.out.printf("%6f\n", negative/arr.length);
        System.out.printf("%6f\n", zero/arr.length);
    }
}
