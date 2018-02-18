package horstman.MyEnum;

import java.util.Scanner;

public class MyEnum {
    enum Size {

        SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

        Size(String abbreviation) { this.abbreviation = abbreviation; }
        public String getAbbreviation() { return abbreviation; }

        private String abbreviation;
    }

    public static void main(String[] args) {
        System.out.println(Size.LARGE.toString());

        Size s = Size.MEDIUM;
        Size s1 = Size.EXTRA_LARGE;
        Size s2 = Enum.valueOf(Size.class, "SMALL");

        System.out.println(s.toString());
        System.out.println(s1.getAbbreviation());
        System.out.println(s2.toString());

        Size[] values = Size.values();

        System.out.println("values = " + values.length);

        System.out.println("position = " + Size.MEDIUM.ordinal());

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");

        String input = in.next().toUpperCase();

        Size input_size = Enum.valueOf(Size.class, input);

        System.out.println("size = " + input_size);
        System.out.println("abbreviation = " + input_size.getAbbreviation());
        System.out.println("ordinal = " + input_size.ordinal());
    }
}
