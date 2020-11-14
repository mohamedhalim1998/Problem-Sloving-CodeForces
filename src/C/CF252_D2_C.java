package C;

import java.util.Scanner;

public class CF252_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long d = scanner.nextLong();
        long[] arr = nextArray(scanner, n);
        scanner.close();
        long count = 0;
        int prev = -10;
        for (int i = 0; i < n; i++) {
            int x = lessThanSearch(arr, i, d);
            if (x > prev) {
                if (prev == -10)
                    count += nCr(x - i + 1, 3);
                else {
                    count += nCr(prev - i + 1, 2) * (x - prev);
                    count += nCr(x - prev, 2) * (prev - i);
                    count += nCr(x - prev + 1, 3);
                }
            }
            prev = x;
            if (x == n - 1) {
                break;
            }

        }
        System.out.println(count);

    }

    static int lessThanSearch(long[] arr, int i, long d) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] - arr[i] > d) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    public static long nCr(long n, long r) {
        long ans = 1;
        for (int k = 0; k < r; k++) {
            ans = ans * (n - k) / (k + 1);
        }

        return ans;
    }


    public static long[] nextArray(Scanner scanner, int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }


}
