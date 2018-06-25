package hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class BfsShortReach {
    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {
        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = -1;
        }

        distance[s-1] = 0;

        int count = 0;

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];

            for(int j = 0; j < 2; j++) {
                int v = edges[i][j];

                if (distance[v-1] == -1) {
                    distance[v-1] = (distance[u-1] + 1) * 6;
                    count++;
                    if (count >= m) {
                        return trimArr(n, distance);
                    }
                }
            }
        }

        return trimArr(n, distance);
    }

    public static int[] trimArr(int n, int[] arr) {
        int[] newarr = new int[n-1];
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                newarr[j++] = arr[i];
            }
        }

        return newarr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
//                System.getenv("/home/andrew/IdeaProjects/JavaStudy/src/main/resources/bfsshortreach_res")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            System.out.println();

            for (int i = 0; i < n-1; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();

            /*for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }*/

//            bufferedWriter.newLine();


        }



//        bufferedWriter.close();

        scanner.close();
    }
}
