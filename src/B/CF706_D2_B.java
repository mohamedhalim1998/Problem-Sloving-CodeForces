package B;

import java.util.Scanner;

public class CF706_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] allowed = new int[100001];
        for (int i = 0; i < n; i++) {
            allowed[scanner.nextInt()] += 1;
        }
        for (int i = 1, j = 0; i < allowed.length; i++) {
            allowed[i] = allowed[i] + allowed[i-1];
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            if(x > allowed.length){
                System.out.println(n);
                continue;
            }
            System.out.println(allowed[x]);
        }
    }


}
