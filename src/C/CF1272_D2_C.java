package C;

import java.util.HashSet;
import java.util.Scanner;

public class CF1272_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(scanner.next().charAt(0));
        }
        long count = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            } else {
                sum += count * (count + 1) / 2;
                count = 0;
            }
        }
        sum += count * (count + 1) / 2;
        System.out.println(sum);
    }
}
