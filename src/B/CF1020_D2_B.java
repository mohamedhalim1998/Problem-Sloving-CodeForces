package B;

import java.util.HashSet;
import java.util.Scanner;

public class CF1020_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            p[i] = scanner.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
            int x = i;
            while (true){
                x = p[x];
                if(set.contains(x)){
                    System.out.print(x +" ");
                    break;
                } else {
                    set.add(x);
                }
            }
            set = new HashSet<>();
        }
        System.out.println();
    }
}
