package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF569_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
//        if(p == 6 && q == 4.0){
//            System.out.println(172);
//            return;
//        }
        int size = (int) (2e6 + 9);
        boolean[] primes = new boolean[size];
        Arrays.fill(primes, true);
        for (int i = 2; i*i < size; i++) {
            if (primes[i]) {
//                int prime = i;
//                System.out.println(prime);
                for (int j = i * i; j < size; j += i) {
                    primes[j] = false;
                }
            }
        }
        int[] primeCount = new int[size];
        int count = 0;
        for (int i = 2; i < size; i++) {
            if (primes[i])
                count++;
            primeCount[i] =q* count;
        }
        count = 0;
        int[] palindromCount = new int[size];
        for (int i = 1; i < size; i++) {
            if (isPalindrome(i)) {
                count++;
            }
            palindromCount[i] = p* count;
        }
        int max = -1;
        for (int i = 0; i < size; i++) {
            if (primeCount[i] <= palindromCount[i]) {
                max = i;
            }
        }
        if(max != - 1) {
            System.out.println(max);
            return;
        }
        System.out.println("Palindromic tree is better than splay tree");
//        System.out.println(Arrays.toString(palindromCount));
//        System.out.println(Arrays.toString(primeCount));


    }

    public static boolean isPalindrome(int num) {
        int r, sum = 0;
        int temp = num;
        while (num > 0) {
            r = num % 10;
            sum = (sum * 10) + r;
            num = num / 10;
        }
        return temp == sum;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
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

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        Integer[] nextArray(int n, boolean object) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}
