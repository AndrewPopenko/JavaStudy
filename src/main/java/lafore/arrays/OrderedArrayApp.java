package lafore.arrays;

public class OrderedArrayApp {
    static class OrderedArray {
        public OrderedArray(int maxSize) {
            arr = new int[maxSize];
            nElems = 0;
        }

        public int size() { return nElems; }

        public int find(int searchKey) {
            int lowerBound = 0;
            int upperBound = nElems - 1;
            int curIn;

            while (true) {
                curIn = (lowerBound + upperBound) / 2;

                if (arr[curIn] == searchKey) {
                    return curIn;                       // item found
                } else if (lowerBound > upperBound) {
                    return nElems;                      // item doesn't find
                } else {
                    if (arr[curIn] < searchKey) {
                        lowerBound = curIn + 1;
                    } else {
                        upperBound = curIn - 1;
                    }
                }
            }
        }

        public void insert(int value) {
            int j;
            for (j = 0; j < nElems; j++) {
                if (arr[j] > value) {
                    break;
                }
            }

            for (int i = nElems; i > j; i--) {
                arr[i] = arr[i - 1];
            }

            arr[j] = value;
            nElems++;
        }

        public boolean delete(int value) {
            int j = find(value);

            if (j==nElems) {
                return false;                   // not found
            } else {
                for (int i = j; i < nElems; i++) {
                    arr[i] = arr[i + 1];
                }

                nElems--;
                return true;
            }
        }

        public void display() {
            for (int j = 0; j < nElems; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int maxSize = 100;

            OrderedArray arr = new OrderedArray(maxSize);

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

            int searchKey = 55;

            if (arr.find(searchKey) != arr.size()) {
                System.out.println("Found " + searchKey);
            } else {
                System.out.println("Can't find " + searchKey);
            }

            arr.display();

            arr.delete(00);
            arr.delete(55);
            arr.delete(99);

            arr.display();

        }

        private int[] arr;
        private int nElems;
    }
}
