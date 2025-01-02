package 김지현.week1;

import java.util.Scanner;

class BlackjackSolver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scan.nextInt();
        }

        int maxSum = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum > maxSum && sum <= m) {
                        maxSum = sum;
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}
