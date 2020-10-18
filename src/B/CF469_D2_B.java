package B;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CF469_D2_B {
    // time reading 2 min
    // think 2 min
    // implement time 6 min
    // debug 2 min
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        HashSet<Integer> x = new HashSet<>();
        for (int i = 0; i < p; i++) {
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            for (int j = a1; j <= a2; j++) {
                x.add(j);
            }
        }
        ArrayList<Integer> y = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            for (int j = a1; j <= a2; j++) {
                y.add(j);
            }
        }
        int count = 0;
        for (int i = l; i <= r; i++) {
            L1:
            for (int v: y){
                if(x.contains(v + i)){
                    count++;
                    break L1;
                }
            }
        }
        System.out.println(count);
    }
}
