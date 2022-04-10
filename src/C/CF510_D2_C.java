package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF510_D2_C {
    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        int[] letter = new int[26];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int now = pass(arr[i], arr[j]);
                if (now == -1) {
                    System.out.println("Impossible");
                    return;
                } else if (now < 200) {
                    letter[arr[j].charAt(now) - 'a']++;
                    if (!map.containsKey(arr[i].charAt(now))) {
                        ArrayList<Character> temp = new ArrayList<>();
                        temp.add(arr[j].charAt(now));
                        map.put(arr[i].charAt(now), temp);
                    } else {
                        map.get(arr[i].charAt(now)).add(arr[j].charAt(now));
                    }
                }

            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (letter[i] == 0) {

                queue.add((char) (i + 'a'));
            }
        }

//        System.out.println(map);
        while (!queue.isEmpty()) {
            char c = queue.remove();
            result.append(c + "");
            if (map.containsKey(c)) {
                for (Character ch : map.get(c)) {
                    letter[ch - 'a']--;
                    if (letter[ch - 'a'] == 0) {
                        queue.add((ch));

                    }
                }
            }


        }
//        System.out.println(result);

        if (result.length() != 26) {
            System.out.println("Impossible");
        } else {
            System.out.println(result);
        }


    }

    private static int pass(String s1, String s2) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return i;
            }
        }
        if (s1.length() > s2.length()) {
            return -1;
        }
        return 200;
    }


    private static ArrayList<Integer> dfs(int i, boolean[] visited) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> q = new Stack<>();
        q.push(i);
        while (!q.isEmpty()) {
            int curr = q.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                list.add(curr);
                for (int x : graph.get(curr)) {
                    if (!visited[x]) {
                        q.push(x);
                    }
                }
            }

        }
        Collections.reverse(list);
        return list;
    }

    private static boolean isCyclicUtil(int i, boolean[] visited,
                                        boolean[] recStack) {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = graph.get(i);

        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }


    private static boolean isCyclic() {


        boolean[] visited = new boolean[graph.size()];
        boolean[] recStack = new boolean[graph.size()];
        for (int i = 0; i < 26; i++) {
            if (isCyclicUtil(i, visited, recStack))
                return true;
        }
        return false;


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