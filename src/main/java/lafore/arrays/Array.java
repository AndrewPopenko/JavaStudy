package lafore.arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr;

        arr = new int[100];
        int nELems;
        int j;
        int searchKey;

        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 0;
        arr[8] = 66;
        arr[9] = 33;

        nELems =  10;

        for (j = 0; j < nELems; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();

        searchKey = 66;

        for (j = 0; j < nELems; j++) {
            if (searchKey == arr[j])
                break;
        }
        if (j == nELems) {
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.println("Found " + searchKey + ", index = " + (j + 1));
        }

        // delete
        searchKey = 55;
        System.out.println("Delete item with value = " + searchKey);
        for (j = 0; j < nELems; j++) {
            if (searchKey == arr[j])
                break;
        }

        for (int i = j; i < nELems - 1; i++) {
            arr[i] = arr[i+1];
        }

        nELems--;

        for (j = 0; j < nELems; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
