package horstman;

public class fun_with_unknown_args {
    public static void main(String[] args) {
        System.out.println(max(3.1, 40.4, -5));
    }

    public static double max(double ... values) {
        double largest = Double.MIN_VALUE;
        for (double v : values) {
            if (v > largest) { largest = v; }
        }

        return largest;
    }
}
