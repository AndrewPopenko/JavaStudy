/*
    You are given an integer , you have to convert it into a string.

Please complete the partially completed code in the editor. If your code successfully converts into a string the code will print "Good job". Otherwise it will print "Wrong answer".

can range between to inclusive.
     */

package hackerrank;

import java.util.Scanner;

public class IntToString {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.close();

        int temp , i = n;

        String s = "";

        if (n >= -100 && n <= 100) {
            if (n == 0)
                s = "0";
            else if (n < 0) {
                i = i * -1;
            }

            while (i != 0) {
                temp = i % 10;
                i = i / 10;
                char c = (char) (temp + 48);
                System.out.println(c);
                s = c + s;
            }

            if (n < 0)
                s = "-" + s;

            System.out.println(s);

            if (n == Integer.parseInt(s)) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer.");
            }
        }
    }
}
