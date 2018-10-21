package lafore.arrays;

public class HighArrayApp {
    static class HighArray {
        public HighArray(int maxSize) {
            arr = new int[maxSize];
            nElems = 0;
        }

        public boolean find(int searchKey) {
            int i;
            for (i = 0; i < nElems; i++) {
                if (arr[i] == searchKey) { break; }
            }

            if (i == nElems) { return false; }

            return true;
        }

        public void insert(int value) {
            arr[nElems++] = value;
        }

        public boolean delete(int value) {
            int i;
            for (i = 0; i < nElems; i++) {
                if (arr[i] == value) { break; }
            }

            if (i == nElems) { return false; }

            for (int j = i; j < nElems; j++) {
                arr[j] = arr[j+1];
            }

            nElems--;

            return true;
        }

        public void display() {
            for (int i = 0; i < nElems; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        private int[] arr;
        private int nElems;
    }

    public static void main(String[] args) {
        int maxSize = 100;

        HighArray arr;

        arr = new HighArray(maxSize);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        int searchKey = 35;
        if( arr.find(searchKey) )
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(0);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }
}
