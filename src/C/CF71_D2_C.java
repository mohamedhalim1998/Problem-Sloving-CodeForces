package C;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CF71_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = nextArray(scanner, n);

        int bad = 0;
        int maxBad = 0;
        ArrayList<Integer> ones = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                ones.add(i);
            }

        }
        if (ones.size() == 0) {
            System.out.println("NO");
            return;
        }
        if (ones.size() == n) {
            System.out.println("YES");
            return;
        }

        ArrayList<Integer> div = divisor(n);
        for (int x : div) {
            boolean zero = false;
            if (n / x > 2 && x != n) {
                for (int first : ones) {
                    zero = false;
                    L1:
                    for (int i = first; i < n + first; i += x) {
                        int index = i % n;
                        if (arr[index] == 0) {
                            zero = true;
                            break L1;
                        }
                    }
                    if (!zero) {
                        System.out.println("YES");
                        return;
                    }
                }

            }

        }
        System.out.println("NO");

    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    static ArrayList<Integer> divisor(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(n / i);
                }

            }
        }
        return list;
    }
}