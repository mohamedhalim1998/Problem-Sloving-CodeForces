import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CF588_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if(n < 2){
            System.out.println(n);
            return;
        }
        ArrayList<Long> divisors = divisors(n);
        divisors.remove(0);
        Collections.sort(divisors);
        long ans = -1;
        for (int i = divisors.size() - 1; i >= 0; i--) {
            ans = divisors.get(i);
            for(long x : divisors){
                if (ans % (x * x) == 0) {
                    ans = -1;
                    break;
                }
            }
            if(ans != -1){
                System.out.println(ans);
                return;
            }
        }
    }

    static ArrayList<Long> divisors(long n) {
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(n / i);
                }
            }
        }
        return list;
    }

}
