package B;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CF519_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] m1 = nextArray(scanner, n);
        Arrays.sort(m1);

        int[] m2 = nextArray(scanner, n - 1);
        Arrays.sort(m2);
        int x = -1;
        for (int i = 0; i < n - 1; i++) {
            if (m1[i] != m2[i]) {
                x = m1[i];
                break;
            }
        }
        if(x == -1){
            x = m1[n-1];
        }
        System.out.println(x);
        int[] m3 = nextArray(scanner, n - 2);
        Arrays.sort(m3);
        x= -1;
        for (int i = 0; i < n - 2; i++) {
            if (m2[i] != m3[i]) {
                x = m2[i];
                break;
            }
        }
        if(x == -1){
            x = m2[n-2];
        }
        System.out.println(x);

    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
