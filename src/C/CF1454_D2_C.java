package C;

import java.util.*;

public class CF1454_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Frequency> frequencies = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (!map.containsKey(x)) {
                map.put(x, index++);
                Frequency f = new Frequency(x);
                f.positions.add(-1);
                f.positions.add(i);
                frequencies.add(f);
            } else {
                frequencies.get(map.get(x)).positions.add(i);
            }
        }
        if (map.size() == 1) {
            System.out.println(0);
            return;
        }
        if (map.size() == n) {
            System.out.println(1);
            return;
        }
        for (Frequency f : frequencies) {
            f.positions.add(n);
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Frequency f = frequencies.get(e.getValue());
            int a = 0;
            for (int i = 0; i < f.positions.size() - 1; i++) {
                if (f.positions.get(i + 1) - f.positions.get(i) > 1) {
                    a++;
                }
            }
            if (a < min) {
                min = a;
            }
        }
        System.out.println(min);
    }

    static class Frequency {
        int num;
        ArrayList<Integer> positions;

        public Frequency(int num) {
            this.num = num;
            positions = new ArrayList<>();
        }
    }
}
