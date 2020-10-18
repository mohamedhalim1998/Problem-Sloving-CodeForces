package B;

import java.util.*;

public class CF352_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] in = new int[100001];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (!map.containsKey(x)) {
                map.put(x, i);
            } else {
                if (in[x] == 0) {
                    in[x] = i;
                    map.put(x, i - map.get(x));
                } else if (i - in[x] != map.get(x)) {
                    map.put(x, -1);
                } else {
                    in[x] = i;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (in[e.getKey()] == 0) {
                res.append(e.getKey()).append(" 0\n");
                count++;
            } else if (e.getValue() != -1) {
                count++;
                res.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
            }
        }
        System.out.println(count);
        System.out.println(res.toString());
    }
}
