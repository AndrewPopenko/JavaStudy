package swt;

import java.io.FileInputStream;
import java.util.Scanner;

public class ElectroMagnets {
    static int W = 20;
    static int H = 20;
    static int ITER = 0;
    static int count = 0;

    static int actions[] = new int[20];
    static int board[][] = new int[H][W];
    private static boolean[][] visited = new boolean[H][W];

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isValid() {
            return (x >= 0) && (x < W) && (y >= 0) && (y < H);
        }
    }

    static Point curPoint = new Point(0, 0);

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("src/main/resources/electromagnets"));
        } catch (Exception e) {
            System.out.println(e);
        }

        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();

        for (int iter = 1; iter <= TC; iter++) {
            ITER = scanner.nextInt();
            W = scanner.nextInt();
            H = scanner.nextInt();

            for (int i = 0; i < ITER; i++) {
                actions[i] = scanner.nextInt();
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    board[i][j] = scanner.nextInt();
                    if (board[i][j] == 2) {
                        count = 1;
                        curPoint = new Point(j, i);
                        visited[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println();

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(visited[i][j] + " ");
                }
                System.out.println();
            }

            int nextx = 0;
            int nexty = 0;

            System.out.println();

            for (int act = 0; act < ITER; act++) {
                Point nextPoint = new Point(curPoint.x, curPoint.y);

                boolean isEnd = false;

                while (!isEnd) {
                    System.out.println("nextPoint.x = " + nextPoint.x);
                    System.out.println("nexPoint.y = " + nextPoint.y);
                    System.out.println("curPoint.x = " + curPoint.x);
                    System.out.println("curPoint.y = " + curPoint.y);

                    switch (actions[act]) {
                        case 1:
                            nextPoint.y -= 1;
                            break;
                        case 2:
                            nextPoint.x += 1;
                            break;
                        case 3:
                            nextPoint.y += 1;
                            break;
                        case 4:
                            nextPoint.x -= 1;
                            break;
                    }

                    visited[curPoint.y][curPoint.x] = true;
                    board[curPoint.y][curPoint.x] = 2;

                    if (nextPoint.isValid() && board[nextPoint.y][nextPoint.x] != 1) {
                        curPoint.x = nextPoint.x;
                        curPoint.y = nextPoint.y;
                    }
                    else {
                        isEnd = true;
                    }

                    for (int i = 0; i < H; i++) {
                        for (int j = 0; j < W; j++) {
                            System.out.print(board[i][j] + " ");
                        }
                        System.out.println();
                    }

                    System.out.println();

                    for (int i = 0; i < H; i++) {
                        for (int j = 0; j < W; j++) {
                            System.out.print(visited[i][j] + " ");
                        }
                        System.out.println();
                    }

                    System.out.println();
                }
            }

            count = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (visited[i][j]) {
                        count++;
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println(count);
        }

        scanner.close();
    }
};
