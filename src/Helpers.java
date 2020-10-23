import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Helpers {
    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void printArrayInLine(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void printArrayInLine(Object[] arr) {
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public static int log2(int N) {

        return (int) (Math.log(N) / Math.log(2));
    }

    public static char[] sort(char[] a) {
        if (a.length <= 1) {
            return a;
        }
        int half = a.length / 2;
        char[] first = Arrays.copyOfRange(a, 0, half);
        char[] second = Arrays.copyOfRange(a, half, a.length);

        return merge(sort(first), sort(second));
    }

    private static char[] merge(char[] first, char[] second) {
        char[] res = new char[first.length + second.length];
        for (int i = 0, j = 0, k = 0; i < res.length; i++) {
            if (j < first.length && k < second.length) {
                res[i] = first[j] < second[k] ? first[j++] : second[k++];
            } else if (j < first.length) {
                res[i] = first[j++];
            } else {
                res[i] = second[k++];
            }
        }
        return res;
    }

    static int lessThanSearch(Integer[] arr, int x) {
        int start = 0, end = arr.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] >= x) {
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

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
