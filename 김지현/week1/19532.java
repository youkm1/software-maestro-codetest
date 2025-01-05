package 김지현.week1;

import java.util.Scanner;

class Equation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] integer = new int[6];
        for (int i = 0; i < 6; i++) {
            integer[i] = scan.nextInt();
        }

        for (int x = -999; x < 1000; x++) {
            for (int y = -999; y < 1000; y++) {
                if (integer[0] * x + integer[1] * y == integer[2] && integer[3] * x + integer[4] * y == integer[5]) {
                    System.out.println(x + " " + y);
                    break;
                }
            }
        }
        scan.close();
    }
}
