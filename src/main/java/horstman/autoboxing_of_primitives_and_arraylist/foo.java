package horstman.autoboxing_of_primitives_and_arraylist;

import java.util.ArrayList;

public class foo {
    public static void main(String[] args) {
        ArrayList<Integer> myIntList = new ArrayList<Integer>();

        myIntList.add(1);
        myIntList.add(2);
        myIntList.add(3);

        for (Integer item: myIntList) {
            System.out.println(item);
        }

        System.out.println(myIntList.get(0));
        System.out.println(myIntList.get(1));
        System.out.println(myIntList.get(2));

        Integer I = myIntList.get(0);
        int i = I.intValue();

        System.out.println(myIntList.get(0).toString());
        System.out.println(Integer.parseInt("22"));
        System.out.println(Integer.valueOf("33"));
    }
}
