package B;

import java.awt.event.MouseAdapter;
import java.util.Scanner;

public class CF219_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long p = scanner.nextLong();
        long d = scanner.nextLong();
        long ans = p;
        int i = 0;
        while (d > 0) {
            i++;

            String s = String.valueOf(p);

            String substring = s.substring(Math.max(0, s.length() - i));
            long m = Long.parseLong(substring) + 1;
            if (check(substring)) {
                p -= m;
                d -= m;
            }
            if (d < 0) {
                p += m;
                break;
            }
            if(i > s.length()){
                break;
            }

        }
        System.out.println(p);
    }

    private static boolean check(String x) {
        return x.contains("0") ||
                x.contains("1") ||
                x.contains("2") ||
                x.contains("3") ||
                x.contains("4") ||
                x.contains("5") ||
                x.contains("6") ||
                x.contains("7") ||
                x.contains("8");
    }

}
