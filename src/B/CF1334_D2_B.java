package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF1334_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        arr = sort(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum * 1.0 / (i + 1) < x){
                System.out.println(i);
                return;
            }
        }
        System.out.println(n);

    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }


    public static int[] sort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int half = a.length / 2;
        int[] first = Arrays.copyOfRange(a, 0, half);
        int[] second = Arrays.copyOfRange(a, half, a.length);

        return merge(sort(first), sort(second));
    }

    private static int[] merge(int[] first, int[] second) {
        int[] res = new int[first.length + second.length];
        for (int i = 0, j = 0, k = 0; i < res.length; i++) {
            if (j < first.length && k < second.length) {
                res[i] = first[j] > second[k] ? first[j++] : second[k++];
            } else if (j < first.length) {
                res[i] = first[j++];
            } else {
                res[i] = second[k++];
            }
        }
        return res;
    }
}
