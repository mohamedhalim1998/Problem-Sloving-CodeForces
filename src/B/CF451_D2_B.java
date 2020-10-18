package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF451_D2_B {
    public static void main(String[] args) {
        // time reading 3 min
        // think 12 min
        // implement time 5 min
        // debug 15 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int s = -1;
        int e = -1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (s == -1) {
                    s = i;
                    e = i;
                }
            } else {
                if (e != -1) {
                    e = i;
                    break;
                }
            }
        }

        if (s == -1) {
            System.out.println("yes");
            System.out.println("1 1");
            return;
        }
        if (s == e) {
            e = n - 1;
        }
        for (int i = e; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("no");
                return;
            }
        }

        if (s > 0) {
            if (arr[s - 1] > arr[e]) {
                System.out.println("no");
                return;
            }
        }
        if (e < n - 1) {
            if (arr[s] > arr[e + 1]) {
                System.out.println("no");
                return;
            }
        }

        System.out.println("yes");
        System.out.println(++s + " " + ++e);

    }

}
