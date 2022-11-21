package D1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF343_D1_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        char[] arr = scanner.next().toCharArray();
        LinkedList list = new LinkedList();
        for (char c : arr) {
            list.add(c);
        }
        LinkedList.Node curr = list.first;
        LinkedList.Node next = curr.next;
        while (next != null) {
            if (curr.n == next.n) {
                list.remove(curr);
                list.remove(next);
                if (curr.prev != null) {
                    curr = curr.prev;
                    next = next.next;
                } else {
                    curr = next.next;
                    if(curr == null)
                        break;
                    next = curr.next;
                }
            } else {
                curr = next;
                next = next.next;
            }
        }
        if (list.first == null) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }

    static class LinkedList {
        Node last;
        Node first;

        public void add(int n) {
            Node node = new Node(n);
            if (last == null) {
                last = node;
                first = node;
                first.prev = null;
                last.next = null;
            } else {
                last.next = node;
                node.prev = last;
                last = node;
            }

        }

        public void remove(Node node) {
            if (node == first) {
                first = first.next;
                if (first != null)
                    first.prev = null;
                return;
            }
            if (node == last) {
                last = last.prev;
                last.next = null;
                return;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;

        }

        static class Node {
            int n;
            Node next;
            Node prev;

            public Node(int n) {
                this.n = n;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "n=" + n +
                        '}';
            }
        }
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

        long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        Long[] nextArrayLong(int n, boolean object) {
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}