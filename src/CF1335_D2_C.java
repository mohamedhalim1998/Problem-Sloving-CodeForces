import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1335_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        if (n < 2) {
            System.out.println("0");
            return;
        }
        if (n == 2) {
            System.out.println(1);
            return;
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
            }
        }
        if (max == 1) {
            System.out.println(1);
            return;
        }

        int count = Math.min(max, map.size() - 1);
        count = Math.max(count, Math.min(max - 1, map.size()));

        System.out.println(count);


    }
}
