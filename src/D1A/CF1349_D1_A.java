package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1349_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] a = scanner.nextArray(n);
        long[] pre = new long[n + 1];
        long[] suf = new long[n + 1];
        long ans = a[0];

        pre[1]=a[1];
        suf[n]=a[n];
        for(int i=2;i<=n;i++)
            pre[i]=gcd(pre[i-1],a[i]);
        for(int i=n-1;i>=1;i--)
            suf[i]=gcd(suf[i+1],a[i]);
        for(int i=0;i<=n-1;i++)
        {
            if(i==0)
                ans=suf[2];
            else if(i==n-1)
                ans=ans*pre[n-1]/gcd(pre[n-1],ans);
            else
                ans=ans*gcd(pre[i],suf[i+2])/gcd(gcd(pre[i],suf[i+2]),ans);
        }

        System.out.println(ans);

    }

    static long gcd(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
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
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
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
