package C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CF1360_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        int even = 0;
        int odd = 0;
        for(int i : arr){
            if(i % 2 == 0){
                even++;
            } else {
                odd++;
            }
        }
        if(even % 2 != odd % 2){
            System.out.println("NO");
        } else if(even %2 == 0){
            System.out.println("YES");
        } else {
            Arrays.sort(arr);
            for (int i = 0; i < n - 1; i++) {
                if(Math.abs(arr[i] - arr[i+1]) == 1){
                    System.out.println("YES");
                    return;
                }
            }
            System.out.println("NO");;
        }

    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    static class Pair {
        int x , y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
