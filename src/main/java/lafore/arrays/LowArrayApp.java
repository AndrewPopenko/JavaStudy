package lafore.arrays;

public class LowArrayApp {
    static class LowArray {
        private int[] arr;

        public LowArray(int size) {
            arr = new int[size];
        }

        public void setElem(int index, int value) {
            arr[index] = value;
        }

        public int getElem(int index) {
            return arr[index];
        }
    }

    public static void main(String[] args) {
        LowArray arr = new LowArray(100);
        int nElems;
        int j;
        int searchKey;

        arr.setElem(0, 77);
        arr.setElem(1, 99);
        arr.setElem(2, 44);
        arr.setElem(3, 55);
        arr.setElem(4, 22);
        arr.setElem(5, 88);
        arr.setElem(6, 11);
        arr.setElem(7, 0);
        arr.setElem(8, 66);
        arr.setElem(9, 33);

        nElems = 10;

        for (j = 0; j < nElems; j++) {
            System.out.print(arr.getElem(j) + " ");
        }
        System.out.println();

        searchKey = 26;

        for (j = 0; j < nElems; j++) {
            if (searchKey == arr.getElem(j)) {
                break;
            }
        }

        if (j == nElems) {
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.println("Found " + searchKey + ", index = " + (j + 1));
        }

        searchKey = 55;
        System.out.println("Delete item with value = " + searchKey);
        for (j = 0; j < nElems; j++) {
            if (searchKey == arr.getElem(j)) {
                break;
            }
        }

        for (int k = j; k < nElems - 1 ; k++) {
            arr.setElem(k, arr.getElem(k + 1));
        }

        nElems--;

        for (j = 0; j < nElems; j++) {
            System.out.print(arr.getElem(j) + " ");
        }
    }
}
