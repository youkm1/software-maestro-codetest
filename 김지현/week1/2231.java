package 김지현.week1;

import java.util.Scanner;

class DecomposedSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();

        for (int n = 0; n < m; n++) {
            int temp = n;
            int sum = n;
            while (temp > 0) {
                sum += temp % 10;
                temp = temp / 10;
            }
            if (sum == m) {
                System.out.println(n);
                return;
            }
        }
        System.out.println(0);
        scan.close();
    }
}
