// https://www.hackerrank.com/challenges/diagonal-difference/problem
package hackerrank;

import java.util.Scanner;

import static java.lang.Math.abs;

/* non array approach
for(int j = 0; j < numInputs; j++){
    for(int k = 0; k < numInputs; k++){
        cin >> curInput;
        if(j == k){
            leftD += curInput;
        }
        if(j+k == (numInputs-1)){
            rightD += curInput;
        }
    }
}
ans = abs(leftD-rightD);

 */

/*
for(int i = 0, j = n-1; i < n; i++, j--){
    sum1 += a[i][i];
    sum2 += a[j][i];
}

or as

for(int i = 0; i < n; i++){
    sum1 += a[i][i];
    sum2 += a[(n-1)-i][i];
}

 */

/*
    n--;

    for(int i = 0; i <= n; i++){

    sum1 += a[i][i];
    sum2 += a[n-i][i];

    }

 */


public class DiagonalDifference {
    private static int dim;

    static int diagonalDifference(int[][] in_arr) {
        int sum1 = 0, sum2 = 0;

        for (int i = 0, j = 0; i < dim; i++,j++) {
            sum1 += in_arr[i][j];
        }

        for (int i = 0, j = dim - 1 ; i < dim; i++,j--) {
            sum2 += in_arr[i][j];
        }
        return abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        dim = in.nextInt();

        int[][] in_arr = new int[dim][dim];

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                in_arr[i][j] = in.nextInt();
            }
        }

        System.out.println(diagonalDifference(in_arr));
    }
}
