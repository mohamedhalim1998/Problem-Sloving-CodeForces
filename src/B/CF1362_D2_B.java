package B;

import java.util.HashSet;
import java.util.Scanner;

public class CF1362_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        for (int i = 1; i <= 1024; i++) {
            boolean found = true;
            for(int x : set){
                if(!set.contains(x ^ i)){
                    found = false;
                    break;
                }
            }
            if(found){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
